package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.CommandInit;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModServerInit {
    public static void registerCommands(final RegisterCommandsEvent event) {
        CommandInit.registerCommands(event);
    }
}
