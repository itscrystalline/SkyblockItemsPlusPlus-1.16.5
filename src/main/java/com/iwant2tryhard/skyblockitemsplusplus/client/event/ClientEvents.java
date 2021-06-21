package com.iwant2tryhard.skyblockitemsplusplus.client.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.gui.ElectricCraftingTableScreen;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event)
    {
        ScreenManager.register(ContainerInit.ELECTRIC_CRAFTING_TABLE.get(), ElectricCraftingTableScreen::new);
    }
}
