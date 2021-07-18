package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModInit {
    public static void init(final FMLCommonSetupEvent event)
    {
        CapabilityPlayerSkills.register();

        /*MinecraftForge.EVENT_BUS.addListener(PlayerSkillsEventHandler::onAttachCapabilitiesEvent);
        MinecraftForge.EVENT_BUS.addListener(PlayerSkillsEventHandler::AwardCombatStats);
        MinecraftForge.EVENT_BUS.addListener(PlayerSkillsEventHandler::AwardMiningStats);
        MinecraftForge.EVENT_BUS.addListener(PlayerSkillsEventHandler::AwardAlchemyStats);*/
    }
}
