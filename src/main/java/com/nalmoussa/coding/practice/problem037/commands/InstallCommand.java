package com.nalmoussa.coding.practice.problem037.commands;

public class InstallCommand extends CommandBase {
    public InstallCommand(String componentName) {
        super(CommandType.INSTALL, componentName);
    }

    public String getComponentName() {
        return this.componentName;
    }

    @Override
    public String line() {
        return String.format("%s %s", commandType.name(), componentName);
    }
}
