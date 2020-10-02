package com.nalmoussa.coding.practice.problem037.commands;

import java.util.List;

public class DependCommand extends CommandBase {
    private final List<String> requires;

    public DependCommand(String componentName, List<String> requires) {
        super(CommandType.DEPEND, componentName);
        this.requires = requires;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public List<String> getRequires() {
        return this.requires;
    }

    @Override
    public String line() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s %s", commandType.name(), componentName));
        requires.forEach(dependency -> stringBuilder.append(String.format(" %s", dependency)));
        return stringBuilder.toString();
    }
}
