package com.nalmoussa.coding.practice.problem037.commands;

public abstract class CommandBase implements Command {
    final CommandType commandType;
    final String componentName;

    CommandBase(CommandType commandType, String componentName) {
        this.commandType = commandType;
        this.componentName = componentName;
    }

    @Override
    public CommandType getType() {
        return commandType;
    }
}
