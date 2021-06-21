package com.iwant2tryhard.skyblockitemsplusplus.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientUtils {
    public static void SendPrivateMessage(String message)
    {
        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(message), false);
    }
}
