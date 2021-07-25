package com.iwant2tryhard.skyblockitemsplusplus.slayers.util;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import net.minecraft.util.text.TranslationTextComponent;

public enum SlayerStatus {
    SLAYER_NOT_INITIALIZED(-1, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_not_initialized")),
    SLAYER_NOT_STARTED(0, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_not_started")),
    SLAYER_STARTED_ZOMBIE(1, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_started_zombie")),
    SLAYER_STARTED_SPIDER(2, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_started_spider")),
    SLAYER_STARTED_WOLF(3, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_started_wolf")),
    SLAYER_STARTED_ENDERMAN(4, ClientUtils.DirectTranslationInit("slayer.skyblockitemsplusplus.slayer_started_enderman"));

    public final int status;
    public final TranslationTextComponent name;
    SlayerStatus(int status, TranslationTextComponent name)
    {
        this.status = status;
        this.name = name;
    }
    public static int toId(SlayerStatus status)
    {
        return status.status;
    }
    public static SlayerStatus fromId(int id)
    {
        switch (id)
        {
            case 0:
                return SLAYER_NOT_STARTED;
            case 1:
                return SLAYER_STARTED_ZOMBIE;
            case 2:
                return SLAYER_STARTED_SPIDER;
            case 3:
                return SLAYER_STARTED_WOLF;
            case 4:
                return SLAYER_STARTED_ENDERMAN;
            default:
                return SLAYER_NOT_INITIALIZED;
        }
    }
}
