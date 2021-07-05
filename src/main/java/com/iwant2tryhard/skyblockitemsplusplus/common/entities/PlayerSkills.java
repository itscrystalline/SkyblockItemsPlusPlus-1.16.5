package com.iwant2tryhard.skyblockitemsplusplus.common.entities;

import net.minecraft.entity.player.PlayerEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PlayerSkills {
    private final PlayerEntity owner;

    public static int combatLvl;
    public static int combatXp;

    public PlayerSkills(PlayerEntity owner)
    {
        this.owner = owner;
    }

    public PlayerEntity getOwner() {
        return owner;
    }

    public static void AwardCombatXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++combatXp;
            CheckXP();
            qxp -= 1;
        }
    }

    private static void CheckXP()
    {
        if (combatXp > (Math.pow((combatLvl + 3), 2) - Math.pow((combatLvl + 1), 2)) * 10)
        {
            ++combatLvl;
            combatXp = 0;
        }
    }

}
