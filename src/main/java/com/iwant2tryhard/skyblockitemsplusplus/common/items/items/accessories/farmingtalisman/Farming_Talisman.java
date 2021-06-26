package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.farmingtalisman;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main.AccessoryItem;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Color;
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
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) entityIn;
            Block aboveFeetBlock = worldIn
                    .getBlockState(new BlockPos(player.position().x, player.position().y + 1, player.position().z))
                    .getBlock();
            Block feetBlock = worldIn
                    .getBlockState(new BlockPos(player.position().x, player.position().y, player.position().z))
                    .getBlock();
            Block belowFeetBlock = worldIn
                    .getBlockState(new BlockPos(player.position().x, player.position().y - 1, player.position().z))
                    .getBlock();
            //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("block: " + feetBlock + " ," + belowFeetBlock), false);
            if (feetBlock instanceof BushBlock || belowFeetBlock instanceof BushBlock || aboveFeetBlock instanceof BushBlock ||
                    feetBlock instanceof SugarCaneBlock || belowFeetBlock instanceof SugarCaneBlock || aboveFeetBlock instanceof SugarCaneBlock ||
                    feetBlock instanceof FarmlandBlock || belowFeetBlock instanceof FarmlandBlock || aboveFeetBlock instanceof FarmlandBlock) {
                {
                    player.setSpeed(((((player.getSpeed() / 0.699999988079071f) * 100f) + speedBoost) / 100f) * 0.699999988079071f);
                    ClientUtils.SendPrivateMessage("speed: " + ((player.getSpeed() / 0.699999988079071f) * 100f));
                }
            }
            //ClientUtils.SendPrivateMessage("speed: " + ((player.getSpeed() / 0.699999988079071f) * 100f));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Increases your " + ColorText.WHITE + "Speed" + ColorText.GRAY + " by"));
        text.add(new StringTextComponent(ColorText.GREEN + "+10" + ColorText.GRAY + " while held over " + ColorText.AQUA + "farm-related" + ColorText.GRAY + " blocks."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.BOLD.toString() + "COMMON ACCESSORY"));
        super.appendHoverText(stack, world, text, toolTip);
    }
}
