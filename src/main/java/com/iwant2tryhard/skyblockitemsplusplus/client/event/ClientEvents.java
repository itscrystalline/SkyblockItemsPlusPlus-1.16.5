package com.iwant2tryhard.skyblockitemsplusplus.client.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.gui.ElectricCraftingTableScreen;
import com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.render.DragonCrystalRenderer;
import com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.render.ZealotEntityRender;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ContainerInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EntityTypeInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    public static void clientSetup(final FMLClientSetupEvent event)
    {
        ScreenManager.register(ContainerInit.ELECTRIC_CRAFTING_TABLE.get(), ElectricCraftingTableScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.ZEALOT.get(), ZealotEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.DRAGON_CRYSTAL.get(), DragonCrystalRenderer::new);
    }
}
