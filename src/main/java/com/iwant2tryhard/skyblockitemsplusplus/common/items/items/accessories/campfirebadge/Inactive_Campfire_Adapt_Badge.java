package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.campfirebadge;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main.AccessoryItem;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Inactive_Campfire_Adapt_Badge extends AccessoryItem {
    public Inactive_Campfire_Adapt_Badge(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Have a 1 in 40 chance to heal 1 health every second"));
        text.add(new StringTextComponent(ColorText.GRAY + "after 3 seconds while burning."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.GRAY.toString() + ColorText.BOLD.toString() + "RARE ACCESSORY"));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GOLD.toString() + "RIGHT CLICK to activate this accessory! (10 XP)"));
        super.appendHoverText(stack, world, text, toolTip);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.experienceLevel >= 10)
        {
            player.getItemInHand(hand).setCount(0);
            player.inventory.add(ItemInit.CAMPFIRE_ADAPT_BADGE.get().getDefaultInstance());
            player.experienceLevel -= 10;
            world.playSound(player, player, SoundEvents.LAVA_EXTINGUISH, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            return ActionResult.success(player.getItemInHand(hand));
        }
        return ActionResult.fail(player.getItemInHand(hand));
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
