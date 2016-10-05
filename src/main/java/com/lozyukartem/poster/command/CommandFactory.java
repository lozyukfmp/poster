package com.lozyukartem.poster.command;

import com.lozyukartem.poster.command.impl.ChangeLocaleCommand;
import com.lozyukartem.poster.command.impl.LoginCommand;
import com.lozyukartem.poster.command.impl.LogoutCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {
    private static volatile CommandFactory instance = null;
    private Map<CommandName, Command> commands = null;

    private CommandFactory() {
        commands = new HashMap<>();
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.LOGOUT, new LogoutCommand());
        commands.put(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand());
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            synchronized (CommandFactory.class) {
                if (instance == null) {
                    instance = new CommandFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public Command getCommand(CommandName commandName) {
        return commands.get(commandName);
    }

}
