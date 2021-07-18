package com.iwant2tryhard.skyblockitemsplusplus.capabilities.util;

public enum ItemReforges {
    NONE(-1, -1),

    SWORD_GENTLE(0, 0),
    SWORD_ODD(0, 1),
    SWORD_FAST(0, 2),
    SWORD_FAIR(0, 3),
    SWORD_EPIC(0, 4),
    SWORD_SHARP(0, 5),
    SWORD_HEROIC(0, 6),
    SWORD_SPICY(0, 7),
    SWORD_LEGENDARY(0, 8),
    SWORD_sDIRTY(0, 9),
    SWORD_sFABLED(0, 10),
    SWORD_sSUSPICIOUS(0, 11),
    SWORD_sGILDED(0, 12),
    SWORD_sWARPED(0, 13),
    SWORD_sWITHERED(0, 14),
    SWORD_sBULKY(0, 15),
    SWORD_sSEEK(0, 16);

    public final int reforgeItemType;
    public final int reforgeType;
    ItemReforges(int reforgeItemType, int reforgeType)
    {
        this.reforgeItemType = reforgeItemType;
        this.reforgeType = reforgeType;
    }

    public static ItemReforges toReforgeData(int reforgeItemType, int reforgeType)
    {
        if (reforgeItemType == -1 & reforgeType == -1) {return NONE;}

        switch (reforgeItemType)
        {
            case 0:
                switch (reforgeType)
                {
                    case 0:
                        return SWORD_GENTLE;
                    case 1:
                        return SWORD_ODD;
                    case 2:
                        return SWORD_FAST;
                    case 3:
                        return SWORD_FAIR;
                    case 4:
                        return SWORD_EPIC;
                    case 5:
                        return SWORD_SHARP;
                    case 6:
                        return SWORD_HEROIC;
                    case 7:
                        return SWORD_SPICY;
                    case 8:
                        return SWORD_LEGENDARY;
                    case 9:
                        return SWORD_sDIRTY;
                    case 10:
                        return SWORD_sFABLED;
                    case 11:
                        return SWORD_sSUSPICIOUS;
                    case 12:
                        return SWORD_sGILDED;
                    case 13:
                        return SWORD_sWARPED;
                    case 14:
                        return SWORD_sWITHERED;
                    case 15:
                        return SWORD_sBULKY;
                    case 16:
                        return SWORD_sSEEK;
                }
            default:
                return NONE;
        }
    }

    public static int[] fromReforgeData(ItemReforges reforgeData)
    {
        int[] result = new int[2];
        result[0] = reforgeData.reforgeItemType;
        result[1] = reforgeData.reforgeType;
        return result;
    }
}
