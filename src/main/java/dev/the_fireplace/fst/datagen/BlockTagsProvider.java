package dev.the_fireplace.fst.datagen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.AbstractTagProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import dev.the_fireplace.fst.tags.FSTBlockTags;

import java.nio.file.Path;

public class BlockTagsProvider extends AbstractTagProvider<Block> {
    public BlockTagsProvider(DataGenerator dataGenerator) {
        super(dataGenerator, Registry.BLOCK);
    }

    @Override
    protected void configure() {
        this.getOrCreateTagBuilder(FSTBlockTags.FALLING_ROCKS).add(
            Blocks.STONE, Blocks.DIORITE, Blocks.GRANITE, Blocks.ANDESITE,
            Blocks.BASALT, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.COAL_ORE, Blocks.DIAMOND_ORE,
            Blocks.EMERALD_ORE, Blocks.GOLD_ORE, Blocks.IRON_ORE, Blocks.LAPIS_ORE, Blocks.NETHER_GOLD_ORE,
            Blocks.NETHER_QUARTZ_ORE, Blocks.REDSTONE_ORE
        );
        this.getOrCreateTagBuilder(FSTBlockTags.SLIME_ABSORBABLES).add(Blocks.SLIME_BLOCK, Blocks.HONEY_BLOCK);
        this.getOrCreateTagBuilder(FSTBlockTags.MAGMA_ABSORBABLES).add(Blocks.MAGMA_BLOCK);
    }

    @Override
    protected Path getOutput(Identifier identifier) {
        return this.root.getOutput()
            .resolve("data")
            .resolve(identifier.getNamespace())
            .resolve("tags").resolve("blocks")
            .resolve(identifier.getPath() + ".json");
    }

    @Override
    public String getName() {
        return "FST Block Tags";
    }
}
