package com.iwant2tryhard.skyblockitemsplusplus.common.util;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;

public enum CustomRarity {
    COMMON(ColorText.BOLD + ColorText.WHITE.toString() + "COMMON "),
    UNCOMMON(ColorText.BOLD + ColorText.GREEN.toString() + "UNCOMMON "),
    RARE(ColorText.BOLD + ColorText.BLUE.toString() + "RARE "),
    EPIC(ColorText.BOLD + ColorText.DARK_PURPLE.toString() + "EPIC "),
    LEGENDARY(ColorText.BOLD + ColorText.GOLD.toString() + "LEGENDARY "),
    MYTHIC(ColorText.BOLD + ColorText.LIGHT_PURPLE.toString() + "MYTHIC "),
    SPECIAL(ColorText.BOLD + ColorText.RED.toString() + "SPECIAL "),
    VERY_SPECIAL(ColorText.BOLD + ColorText.DARK_RED.toString() + "VERY SPECIAL "),
    SUPREME(ColorText.BOLD + ColorText.RED.toString().toString() + "SUPREME ");

    private final String rarity;
    CustomRarity(String rarity){ this.rarity = rarity; }

    @Override
    public String toString() {
        return rarity;
    }
}
