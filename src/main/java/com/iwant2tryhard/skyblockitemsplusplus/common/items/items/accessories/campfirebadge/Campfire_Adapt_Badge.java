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

public class Campfire_Adapt_Badge extends AccessoryItem {
    public Campfire_Adapt_Badge(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Have a " + ColorText.GOLD + "1 in 40" + ColorText.GRAY + " chance to heal " + ColorText.RED + "1 health" + ColorText.GRAY + " every second"));
        text.add(new StringTextComponent(ColorText.GRAY + "after 3 seconds while burning."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.BLUE.toString() + ColorText.BOLD.toString() + "RARE ACCESSORY"));
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
