package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.enchantments.TelekinesisEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SkyblockItemsPlusPlus.MOD_ID);

    public static final RegistryObject<Enchantment> TELEKINESIS = ENCHANTMENTS.register("telekinesis",
            () -> new TelekinesisEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentType.create("TOOLS", item -> item instanceof SwordItem | item instanceof ToolItem | item instanceof BowItem | item instanceof CrossbowItem),
                    new EquipmentSlotType[]{EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND}));
}
