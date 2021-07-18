package com.iwant2tryhard.skyblockitemsplusplus.common.util;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public enum CustomRarity {
    COMMON(ColorText.BOLD.toString() + ColorText.WHITE.toString() + "COMMON "),
    UNCOMMON(ColorText.BOLD.toString() + ColorText.GREEN.toString() + "UNCOMMON "),
    RARE(ColorText.BOLD.toString() + ColorText.BLUE.toString() + "RARE "),
    EPIC(ColorText.BOLD.toString() + ColorText.DARK_PURPLE.toString() + "EPIC "),
    LEGENDARY(ColorText.BOLD.toString() + ColorText.GOLD.toString() + "LEGENDARY "),
    MYTHIC(ColorText.BOLD.toString() + ColorText.LIGHT_PURPLE.toString() + "MYTHIC "),
    SPECIAL(ColorText.BOLD.toString() + ColorText.RED.toString() + "SPECIAL "),
    VERY_SPECIAL(ColorText.BOLD.toString() + ColorText.DARK_RED.toString() + "VERY SPECIAL "),
    SUPREME(ColorText.BOLD.toString() + ColorText.RED.toString().toString() + "SUPREME ");

    private final String rarity;
    CustomRarity(String rarity){ this.rarity = rarity; }

    @Override
    public String toString() {
        return rarity;
    }

    public static ITextComponent getColorId(CustomRarity rarity)
    {
        switch (rarity)
        {
            case UNCOMMON:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.uncommon");
            case RARE:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.rare");
            case EPIC:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.epic");
            case LEGENDARY:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.legendary");
            case MYTHIC:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.mythic");
            case SPECIAL:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.special");
            case VERY_SPECIAL:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.very_special");
            case SUPREME:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.supreme");

            default:
                return new TranslationTextComponent("rarity.skyblockitemsplusplus.common");
        }
    }
}
