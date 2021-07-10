package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Aspect_Of_The_End extends SwordItem {
    private final float manaUsage = 10f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    private final float displayManaUsage = 50f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    private final CustomRarity rarity;

    public Aspect_Of_The_End(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+100"/* + (hasOneForAll ? oneForAllText : "")*/));
        tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+100"));
        tooltip.add(new StringTextComponent(""));
        //tooltip.add(new StringTextComponent(ItemStack.appendEnchantmentNames();
        //tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A76" + "Item Ablity: Instant Transmission " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent("\u00A77" + "Teleport " + ColorText.GREEN + "8 blocks " + ColorText.GRAY + "ahead of"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "you and gain " + ColorText.WHITE + "Speed 5"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "for " + ColorText.GREEN + "3 seconds."));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Mana Cost: " + ColorText.AQUA + displayManaUsage + " " + ColorText.GRAY + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (PlayerStats.isEnoughMana(manaUsage, player))
        {
            int foodLevel = PlayerStats.calcManaUsage(manaUsage);

            int multiplier = 0;
            int yAdder = 0;
            boolean hitWall = false;

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x,
                    player.position().y + player.getLookAngle().y,
                    player.position().z + player.getLookAngle().z)).getBlock() instanceof AirBlock
            & !hitWall)
            {
                multiplier = 1;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x,
                        player.position().y + player.getLookAngle().y + 1,
                        player.position().z + player.getLookAngle().z)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 1;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 2,
                    player.position().y + player.getLookAngle().y * 2,
                    player.position().z + player.getLookAngle().z * 2)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 2;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 2,
                        player.position().y + player.getLookAngle().y * 2 + 1,
                        player.position().z + player.getLookAngle().z * 2)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 2;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 3,
                    player.position().y + player.getLookAngle().y * 3,
                    player.position().z + player.getLookAngle().z * 3)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 3;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 3,
                        player.position().y + player.getLookAngle().y * 3 + 1,
                        player.position().z + player.getLookAngle().z * 3)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 3;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 4,
                    player.position().y + player.getLookAngle().y * 4,
                    player.position().z + player.getLookAngle().z * 4)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 4;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 4,
                        player.position().y + player.getLookAngle().y * 4 + 1,
                        player.position().z + player.getLookAngle().z * 4)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 4;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 5,
                    player.position().y + player.getLookAngle().y * 5,
                    player.position().z + player.getLookAngle().z * 5)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 5;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 5,
                        player.position().y + player.getLookAngle().y * 5 + 1,
                        player.position().z + player.getLookAngle().z * 5)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 5;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 6,
                    player.position().y + player.getLookAngle().y * 6,
                    player.position().z + player.getLookAngle().z * 6)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 6;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 6,
                        player.position().y + player.getLookAngle().y * 6 + 1,
                        player.position().z + player.getLookAngle().z)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 6;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 7,
                    player.position().y + player.getLookAngle().y * 7,
                    player.position().z + player.getLookAngle().z * 7)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 7;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 7,
                        player.position().y + player.getLookAngle().y * 7 + 1,
                        player.position().z + player.getLookAngle().z * 7)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 7;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 8,
                    player.position().y + player.getLookAngle().y * 8,
                    player.position().z + player.getLookAngle().z * 8)).getBlock() instanceof AirBlock
                    & !hitWall)
            {
                multiplier = 8;
            }
            else
            {
                if (worldIn.getBlockState(new BlockPos(player.position().x + player.getLookAngle().x * 8,
                        player.position().y + player.getLookAngle().y * 8 + 1,
                        player.position().z + player.getLookAngle().z * 8)).getBlock() instanceof AirBlock
                        & !hitWall)
                {
                    multiplier = 8;
                    yAdder = 1;
                } else {
                    yAdder = 0;
                }
                hitWall = true;
            }

            if (multiplier == 0)
            {
                ClientUtils.SendPrivateMessage(ColorText.RED + "There are blocks in the way!");
            }
            else
            {
                player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);
                worldIn.playSound(player, player, SoundEvents.ENDERMAN_TELEPORT,SoundCategory.NEUTRAL, 1.0f, 1.0f);
                Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Instant Transmission! " + "\u00A73" + "(" + (foodLevel * 5) + " Mana)"), false);

                player.setPos(player.position().x + player.getLookAngle().x * multiplier,
                        player.position().y + player.getLookAngle().y * multiplier + (yAdder + 1),
                        player.position().z + player.getLookAngle().z * multiplier);
                if (multiplier != 8)
                {
                    ClientUtils.SendPrivateMessage(ColorText.RED + "There are blocks in the way!");
                }
            }




            //testing
            /*worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x,
                    player.position().y + player.getLookAngle().y,
                    player.position().z + player.getLookAngle().z), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 2,
                            player.position().y + player.getLookAngle().y * 2,
                            player.position().z + player.getLookAngle().z * 2), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 3,
                            player.position().y + player.getLookAngle().y * 3,
                            player.position().z + player.getLookAngle().z * 3), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 4,
                            player.position().y + player.getLookAngle().y * 4,
                            player.position().z + player.getLookAngle().z * 4), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 5,
                            player.position().y + player.getLookAngle().y * 5,
                            player.position().z + player.getLookAngle().z * 5), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 6,
                            player.position().y + player.getLookAngle().y * 6,
                            player.position().z + player.getLookAngle().z * 6), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 7,
                            player.position().y + player.getLookAngle().y * 7,
                            player.position().z + player.getLookAngle().z * 7), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);
            worldIn.setBlock(new BlockPos(player.position().x + player.getLookAngle().x * 8,
                            player.position().y + player.getLookAngle().y * 8,
                            player.position().z + player.getLookAngle().z * 8), Blocks.RED_STAINED_GLASS.defaultBlockState(),
                    2);*/
            //end of testing


            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60, 4));
            worldIn.playSound(player, player, SoundEvents.ENDERMAN_TELEPORT,SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        //return super.use(worldIn, player, hand);
        return ActionResult.success(player.getItemInHand(hand));
    }
}
