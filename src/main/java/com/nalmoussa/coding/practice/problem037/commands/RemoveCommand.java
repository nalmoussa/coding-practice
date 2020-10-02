package com.nalmoussa.coding.practice.problem037.commands;

public class RemoveCommand extends CommandBase {
    public RemoveCommand(String componentName) {
        super(CommandType.REMOVE, componentName);
    }

    public String getComponentName() {
        return this.componentName;
    }

    @Override
    public String line() {
        return String.format("%s %s", commandType.name(), componentName);
    }
}
