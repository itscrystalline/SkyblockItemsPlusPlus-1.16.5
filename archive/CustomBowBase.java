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
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class CustomBowBase extends BowItem {
    public CustomBowBase(Properties properties) {
        super(properties);
    }

    public void releaseUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean hasInfinity = playerentity.isCreative() || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY_ARROWS, playerentity) > 0;
            ItemStack ammoStack = playerentity.getProjectile(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - timeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, playerentity, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {
                boolean isTippedArrow = ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW;

                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);
                }

                float velocity = getArrowVelocity(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    if (!worldIn.isClientSide()) {
                        AbstractArrowEntity arrowEntity = createArrow(worldIn, ammoStack, playerentity);

                        arrowEntity.shoot(playerentity, playerentity.getLookAngle().get(Direction.Axis.Z), playerentity.getLookAngle().get(Direction.Axis.Y), 0.0F, velocity * 3.0F, 1.0F);

                        if (velocity == 1.0F) arrowEntity.setIsCritical(true);

                        double damage = getArrowDamage(bowStack, arrowEntity);
                        arrowEntity.setDamage(damage);

                        int knockback = getArrowKnockBack(bowStack, arrowEntity);
                        arrowEntity.setKnockback(knockback);

                        // apply flame enchant
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, playerentity) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        // reduce bow durability
                        bowStack.setDamageValue(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                        });

                        // set if arrow can be picked up from ground
                        if (hasInfinity && !isTippedArrow) {
                            arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        // actually make the arrow entity exist in the world
                        worldIn.addEntity(arrowEntity);
                    }

                    // sound
                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);

                    // use an arrow
                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.inventory.deleteStack(ammoStack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity) {
        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
        return arrowitem.createArrow(worldIn, ammoStack, playerentity);
    }

    protected int getArrowKnockBack(ItemStack stack, AbstractArrowEntity arrowEntity)
    {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity)
    {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        return ((powerLevel > 0) ?  (arrowEntity.getBaseDamage() + (double)powerLevel * 0.5D + 0.5D) :  arrowEntity.getBaseDamage());
    }

    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem().is(ItemTags.ARROWS);
        };
    }
}
