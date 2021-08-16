package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.farmingtalisman;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main.AccessoryItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Farming_Talisman extends AccessoryItem {
    private final int speedBoost;
    public Farming_Talisman(Properties properties, int defenseBoost, int healthBoost, int speedBoost, float manaReductionPercent, int strengthBoost, int speedBoost1) {
        super(properties, defenseBoost, healthBoost, speedBoost, manaReductionPercent, strengthBoost);
        this.speedBoost = speedBoost1;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Increases your " + ColorText.WHITE + "Speed" + ColorText.GRAY + " by"));
        text.add(new StringTextComponent(ColorText.GREEN + "+10" + ColorText.GRAY + " while held over " + ColorText.AQUA + "farm-related" + ColorText.GRAY + " blocks."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.BOLD + "COMMON ACCESSORY"));
        super.appendHoverText(stack, world, text, toolTip);
    }
}
