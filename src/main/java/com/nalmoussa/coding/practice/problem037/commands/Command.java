package com.nalmoussa.coding.practice.problem037.commands;

public interface Command {
    static CommandType typeOf(String commandName) {
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName);
        } catch (IllegalArgumentException ex) {
            String message = "%s is unknown command.";
            throw new IllegalArgumentException(String.format(message, commandName));
        }

        return commandType;
    }

    default String line() {
        return getType().name();
    }

    CommandType getType();
}
