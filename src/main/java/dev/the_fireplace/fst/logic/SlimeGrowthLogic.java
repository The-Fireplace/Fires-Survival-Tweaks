package dev.the_fireplace.fst.logic;

import com.google.common.collect.Sets;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class SlimeGrowthLogic {
    public static Set<BlockPos> getNearbyBlocks(SlimeEntity slimeEntity) {
        Set<BlockPos> set = Sets.newHashSet();

        for(int j = 0; j < 16; ++j) {
            for(int k = 0; k < 16; ++k) {
                for(int l = 0; l < 16; ++l) {
                    double d = (float)j / 15.0F * 2.0F - 1.0F;
                    double e = (float)k / 15.0F * 2.0F - 1.0F;
                    double f = (float)l / 15.0F * 2.0F - 1.0F;
                    double g = Math.sqrt(d * d + e * e + f * f);
                    d /= g;
                    e /= g;
                    f /= g;
                    double h = Math.sqrt(slimeEntity.getSize())+0.25;
                    double m = slimeEntity.x;
                    double n = slimeEntity.y;
                    double o = slimeEntity.z;

                    for(; h > 0.0F; h -= 0.22500001F) {
                        BlockPos blockPos = new BlockPos(m, n, o);
                        set.add(blockPos);

                        m += d * 0.30000001192092896D;
                        n += e * 0.30000001192092896D;
                        o += f * 0.30000001192092896D;
                    }
                }
            }
        }
        return set;
    }
}
