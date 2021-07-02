package com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.items;

import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class RefinedGhastTear extends Item {
    private final CustomRarity rarity;
    public RefinedGhastTear(Properties properties, CustomRarity rarity) {
        super(properties);
        this.rarity = rarity;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        //tooltip.add(new StringTextComponent("tooltip.skyblockitemsplusplus.refined_netherite_ingot"));
        tooltip.add(new StringTextComponent(rarity.toString()));
    }

    @Override
    public boolean isFoil(ItemStack p_77636_1_) {
        return true;
    }
}
