package com.iwant2tryhard.skyblockitemsplusplus.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.concurrent.TransferQueue;

@OnlyIn(Dist.CLIENT)
public class ClientUtils {
    public static void SendPrivateMessage(String message)
    {
        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(message), false);
    }
    public static void SendServerMessage(String message)
    {
        //Minecraft.getInstance().getCurrentServer().
    }
    public static TranslationTextComponent DirectTranslationInit(String msg)
    {
        return new TranslationTextComponent(msg);
    }
}
