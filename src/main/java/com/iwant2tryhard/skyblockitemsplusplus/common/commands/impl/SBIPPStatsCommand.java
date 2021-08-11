package com.iwant2tryhard.skyblockitemsplusplus.common.commands.impl;

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
        player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.YELLOW + "There will be more functionality here!"), false);
        return Command.SINGLE_SUCCESS;
    }
}
