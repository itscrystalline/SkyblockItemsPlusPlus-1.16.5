package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.reforges.CapabilityItemReforges;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EntityTypeInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModInit {
    public static void init(final FMLCommonSetupEvent event) {
        CapabilityPlayerSkills.register();
        CapabilityItemReforges.register();

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeInit.ZEALOT.get(), ZealotEntity.setAttributes().build());
        });
    }
}
