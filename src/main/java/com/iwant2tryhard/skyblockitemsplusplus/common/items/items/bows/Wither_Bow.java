package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.bows;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Wither_Bow extends BowItem {
    private Item arrowItem = Items.ARROW;

    public Wither_Bow(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+30"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Deals " + ColorText.GREEN.toString() + "+100% " + ColorText.GRAY.toString() + "damage to"));
        tooltip.add(new TranslationTextComponent(ColorText.GREEN.toString() + "Withers and Wither "));
        tooltip.add(new TranslationTextComponent(ColorText.GREEN.toString() + "Skeletons."));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent( ColorText.GREEN.toString() + "\u00A7l" +"UNCOMMON BOW"));
    }

    public void releaseUsing(ItemStack stack, World world, LivingEntity entity, int timeLeft) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entity;
            boolean flag = playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack ammoStack = findAmmo((PlayerEntity) entity, stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, world, playerentity, i, !ammoStack.isEmpty() || flag);
            if (i < 0) return;

            if (!ammoStack.isEmpty() || flag) {
                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, stack, playerentity));
                    if (!world.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
                        AbstractArrowEntity arrowEntity = arrowitem.createArrow(world, ammoStack, playerentity);
                        arrowEntity = customArrow(arrowEntity);
                        arrowEntity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        double damage = getArrowDamage(stack, arrowEntity);
                        arrowEntity.setBaseDamage(damage);


                        int knockback = getArrowKnockBack(stack, arrowEntity);
                        arrowEntity.setKnockback(knockback);


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                        });
                        if (flag1 || playerentity.abilities.instabuild && (ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW)) {
                            arrowEntity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        world.addFreshEntity(arrowEntity);
                    }

                    world.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.instabuild) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.inventory.removeItem(ammoStack);
                        }
                    }

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    private ItemStack findAmmo(PlayerEntity entity, ItemStack bowStack)
    {
        return null;
    }

    private int getArrowKnockBack(ItemStack stack, AbstractArrowEntity arrowEntity)
    {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
    }

    private double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity)
    {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        return ((powerLevel > 0) ?  (arrowEntity.getBaseDamage() + (double)powerLevel * 0.5D + 0.5D) :  arrowEntity.getBaseDamage());
    }
}
