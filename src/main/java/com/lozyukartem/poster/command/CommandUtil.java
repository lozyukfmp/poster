package com.lozyukartem.poster.command;

public final class CommandUtil {
    private CommandUtil(){}

    public static CommandName convertCommandParameter(String command) {
        return CommandName.valueOf(command.replace("-", "_").toUpperCase());
    }
}
