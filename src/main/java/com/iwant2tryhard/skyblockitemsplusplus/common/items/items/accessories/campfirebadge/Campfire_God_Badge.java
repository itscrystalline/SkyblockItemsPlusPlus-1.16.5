package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.campfirebadge;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main.AccessoryItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Campfire_God_Badge extends AccessoryItem {


    public Campfire_God_Badge(Properties properties, int defenseBoost, int healthBoost, int speedBoost, float manaReductionPercent, int strengthBoost) {
        super(properties, defenseBoost, healthBoost, speedBoost, manaReductionPercent, strengthBoost);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Have a " + ColorText.GOLD + "1 in 20" + ColorText.GRAY + " chance to heal " + ColorText.RED + "1 health" + ColorText.GRAY + " every second"));
        text.add(new StringTextComponent(ColorText.GRAY + "after 2 seconds while burning."));
        text.add(new StringTextComponent(ColorText.GRAY + "Gain permant " + ColorText.RED + "Regeneration 1 " + ColorText.GRAY + "and " + ColorText.DARK_GRAY + "Resistance 1" + ColorText.GRAY + "."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.GOLD.toString() + ColorText.BOLD.toString() + "LEGENDARY ACCESSORY"));
        super.appendHoverText(stack, world, text, toolTip);
    }

    /*@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class OnFire
    {
        @SubscribeEvent
        public static void OnBadgeActivate(final LivingEvent.LivingUpdateEvent event)
        {

        }
    }*/
}
