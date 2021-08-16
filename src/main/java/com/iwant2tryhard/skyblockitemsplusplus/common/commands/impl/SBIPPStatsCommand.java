package com.iwant2tryhard.skyblockitemsplusplus.common.commands.impl;

import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.commands.BaseCommand;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;

public class SBIPPStatsCommand extends BaseCommand {
    public SBIPPStatsCommand(String name, int permissionLevel, boolean enabled) {
        super(name, permissionLevel, enabled);
    }

    @Override
    public LiteralArgumentBuilder<CommandSource> setExecution() {
        return builder.then(Commands.argument("player", EntityArgument.player()).executes(
                source -> execute(source.getSource(), EntityArgument.getPlayer(source, "player"))));
    }

    private int execute(CommandSource source, ServerPlayerEntity player) {
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.YELLOW +
                    "Combat: " + skills.getCombatLvl() + " " + skills.getCombatXp() + " " +
                    "Mining: " + skills.getMiningLvl() + " " + skills.getMiningXp() + " " +
                    "Foraging: " + skills.getForagingLvl() + " " + skills.getForagingXp() + " " +
                    "Fishing: " + skills.getFishingLvl() + " " + skills.getFishingXp() + " " +
                    "Enchanting: " + skills.getEnchantingLvl() + " " + skills.getEnchantingXp() + " " +
                    "Alchemy: " + skills.getAlchemyLvl() + " " + skills.getAlchemyXp() + " " +
                    "Farming: " + skills.getFarmingLvl() + " " + skills.getFarmingXp() + " " +
                    ColorText.RED + "Health: " + skills.getHealth() + " " + skills.getMaxHealth() + " " + skills.getBaseMaxHealth() + " " +
                    ColorText.GREEN + "Defense: " + skills.getDefense() + " " + skills.getBaseDefense() + " " +
                    ColorText.BLUE + "Mana: " + skills.getMana() + " " + skills.getMaxMana() + " " + skills.getBaseMaxMana() + " " +
                    ColorText.RED + "Strength: " + skills.getStrength() + " " + skills.getBaseStrength() + " " +
                    ColorText.DARK_RED + "Ferocity: " + skills.getFerocity() + " " + skills.getBaseFerocity() + " " +
                    ColorText.WHITE + "Speed: " + skills.getSpeed() + " " + skills.getBaseSpeed() + " " +
                    ColorText.GOLD + "Coins: " + skills.getCoins() + " " + player.getSpeed()), false);
        });
        return Command.SINGLE_SUCCESS;
    }
}
