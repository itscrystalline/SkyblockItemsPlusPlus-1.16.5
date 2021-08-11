package com.iwant2tryhard.skyblockitemsplusplus;

import com.iwant2tryhard.skyblockitemsplusplus.client.event.ClientEvents;
import com.iwant2tryhard.skyblockitemsplusplus.core.event.ModInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.*;
import com.iwant2tryhard.skyblockitemsplusplus.world.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SkyblockItemsPlusPlus.MOD_ID)
public class SkyblockItemsPlusPlus
{
    public static final String MOD_ID = "skyblockitemsplusplus";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup SkyblockItems_Combat = new SkyblockItemsCombat();
    public static final ItemGroup SkyblockItems_Materials = new SkyblockItemsMaterials();
    public static final ItemGroup SkyblockItems_Armors = new SkyblockItemsArmors();
    public static final ItemGroup SkyblockItems_Tools = new SkyblockItemsTools();
    public static final ItemGroup SkyblockItems_Accessories = new SkyblockItemsAccessories();

    //public static final String black_heart_suit = String.valueOf(ChatColor.translateAlternateColorCodes('&', getConfig().getString("black_heart_suit"))) + "+ ChatColor.translateAlternateColorCodes('&', getConfig().getString("suffix_black_heart_suit"));

    public SkyblockItemsPlusPlus() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ModInit::init);
        bus.addListener(ClientEvents::clientSetup);
        //bus.addListener(ModServerInit::registerCommands);

        EnchantmentInit.ENCHANTMENTS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        TileEntityTypeInit.TILE_ENTITY_TYPES.register(bus);
        ContainerInit.CONTAINER_TYPES.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static class SkyblockItemsCombat extends ItemGroup
    {
        public SkyblockItemsCombat()
        {
            super("SkyblockItems_Combat");
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.ROGUE_SWORD.get().getDefaultInstance();
        }
    }
    public static class SkyblockItemsMaterials extends ItemGroup
    {
        public SkyblockItemsMaterials()
        {
            super("SkyblockItems_Materials");
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.REFINED_NETHERITE_BLOCK.get().getDefaultInstance();
        }
    }
    public static class SkyblockItemsArmors extends ItemGroup
    {
        public SkyblockItemsArmors()
        {
            super("SkyblockItems_Armors");
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.FARM_SUIT_HELMET.get().getDefaultInstance();
        }
    }
    public static class SkyblockItemsTools extends ItemGroup
    {
        public SkyblockItemsTools()
        {
            super("SkyblockItems_Tools");
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.NETHERITE_PLATED_DIAMOND_PICKAXE.get().getDefaultInstance();
        }
    }
    public static class SkyblockItemsAccessories extends ItemGroup
    {
        public SkyblockItemsAccessories()
        {
            super("SkyblockItems_Accessories");
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.CAMPFIRE_INITIATE_BADGE.get().getDefaultInstance();
        }
    }
}


