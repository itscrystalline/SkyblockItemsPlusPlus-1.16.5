package com.iwant2tryhard.skyblockitemsplusplus.common.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class BaseCommand {
    protected LiteralArgumentBuilder<CommandSource> builder;
    boolean enabled;

    public BaseCommand(String name, int permissionLevel, boolean enabled) {
        this.builder = Commands.literal(name).requires(sorce -> sorce.hasPermission(permissionLevel));
        this.enabled = enabled;
    }

    public LiteralArgumentBuilder<CommandSource> getBuilder() {
        return builder;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public LiteralArgumentBuilder<CommandSource> setExecution() {
        return null;
    }
}
