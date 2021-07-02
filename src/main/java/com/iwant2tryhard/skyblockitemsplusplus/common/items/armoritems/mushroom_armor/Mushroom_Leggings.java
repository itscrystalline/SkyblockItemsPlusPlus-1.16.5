package com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.mushroom_armor;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Mushroom_Leggings extends ArmorItem {
    private final CustomRarity rarity;
    private static int statMultiplier = 1;
    private static int hp = 2;
    private static int defense = 5;

    public Mushroom_Leggings(IArmorMaterial armorMaterial, EquipmentSlotType slotType, Properties properties, CustomRarity rarity) {
        super(armorMaterial, slotType, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "Health: " + ColorText.GREEN + (hp * statMultiplier) + " HP"));
        tooltip.add(new StringTextComponent("\u00A77" + "Defense: " + ColorText.GREEN + (defense * statMultiplier)));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD + "Full Set Bonus: Night Affinity"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Grants the wearer with"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "permanent Night Vision" + ColorText.GRAY +  " while"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "worn, and during the night, the"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "stats of the armor pieces are"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "tripled" + ColorText.GRAY + "."));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "HELMET"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, world, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Mushroom_Leggings)
            {
                if (player.level.getTimeOfDay(1f) > 13000 | player.level.getTimeOfDay(1f) < 1000)
                {
                    //AttributeModifier modifier = new AttributeModifier(UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC"), player.getItemBySlot(EquipmentSlotType.LEGS).getItem()::getDescriptionId, 2f, AttributeModifier.Operation.ADDITION);
                    //player.getItemBySlot(EquipmentSlotType.LEGS).getItem().getAttributeModifiers(EquipmentSlotType.LEGS, player.getItemBySlot(EquipmentSlotType.LEGS)).put(Attributes.MAX_HEALTH, modifier);
                }
            }

            if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Mushroom_Helmet
                    & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Mushroom_Chestplate
                    & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Mushroom_Leggings
                    & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Mushroom_Boots)
            {
                if (player.level.getTimeOfDay(1f) > 13000 | player.level.getTimeOfDay(1f) < 1000)
                {
                    statMultiplier = 3;
                }
            }
        }
    }
}
