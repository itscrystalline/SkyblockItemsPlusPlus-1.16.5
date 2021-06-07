package com.iwant2tryhard.skyblockitemsplusplus.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class MithrilOreBlock extends OreBlock {
    public MithrilOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? fortune != 0 ? MathHelper.nextInt(RANDOM, 3,10) : MathHelper.nextInt(RANDOM, 1,5) : 0;
    }
}
