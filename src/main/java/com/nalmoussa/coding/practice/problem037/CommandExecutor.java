package com.nalmoussa.coding.practice.problem037;

import com.nalmoussa.coding.practice.problem037.commands.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class CommandExecutor {
    private static final String OUTPUT_FILE_NAME = "target/output.txt";

    private final List<Command> commands;
    private final HashMap<String, List<String>> requiresDependencyMap;
    private final HashMap<String, List<String>> requiredForDependencyMap;
    private final HashMap<String, Component> componentMap;

    CommandExecutor() {
        this.commands = new ArrayList<>();
        this.requiresDependencyMap = new HashMap<>();
        this.requiredForDependencyMap = new HashMap<>();
        this.componentMap = new HashMap<>();
    }

    void readInputFromFile(String inputFileName) throws Exception {
        File file = new File(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            commands.add(parseCommandLine(line));
        }
        bufferedReader.close();
    }

    private Command parseCommandLine(String commandLine) {
        String[] words = commandLine.split("\\s+");
        String commandName = words[0];
        String componentName;
        Command command = null;
        switch (Command.typeOf(commandName)) {
            case DEPEND:
                if (words.length < 3) {
                    final String message = "%s command should have at least two arguments";
                    throw new IllegalArgumentException(String.format(message, CommandType.DEPEND.name()));
                }
                componentName = words[1];
                List<String> requires = Arrays.asList(words).subList(2, words.length);
                command = new DependCommand(componentName, requires);
                break;
            case INSTALL:
                if (words.length < 2) {
                    final String message = "%s command should have at least one argument";
                    throw new IllegalArgumentException(String.format(message, CommandType.INSTALL.name()));
                }
                componentName = words[1];
                command = new InstallCommand(componentName);
                break;
            case REMOVE:
                if (words.length < 2) {
                    final String message = "%s command should have at least one argument";
                    throw new IllegalArgumentException(String.format(message, CommandType.REMOVE.name()));
                }
                componentName = words[1];
                command = new RemoveCommand(componentName);
                break;
            case LIST:
                command = new ListCommand();
                break;
            case END:
                command = new EndCommand();
                break;
        }

        return command;
    }

    void writeOutputToFile() throws Exception {
        File file = new File(OUTPUT_FILE_NAME);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String log : Logger.getLogs()) {
            bufferedWriter.write(log);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    void execute() {
        String componentName;
        Component component;
        for (Command command : commands) {
            Logger.log(command.line());
            switch (command.getType()) {
                case DEPEND:
                    DependCommand dependCommand = (DependCommand)command;
                    componentName = dependCommand.getComponentName();
                    component = new Component(componentName);
                    componentMap.put(componentName, component);
                    addDependency(componentName, dependCommand.getRequires());
                    break;
                case INSTALL:
                    InstallCommand installCommand = (InstallCommand)command;
                    componentName = installCommand.getComponentName();
                    if (componentMap.containsKey(componentName)) {
                        component = componentMap.get(componentName);
                    } else {
                        component = new Component(componentName);
                        componentMap.put(componentName, component);
                    }

                    installRequiredComponentsFor(componentName);
                    component.setStatus(Status.EXPLICITLY_INSTALLED);
                    break;
                case REMOVE:
                    RemoveCommand removeCommand = (RemoveCommand)command;
                    componentName = removeCommand.getComponentName();
                    if (componentMap.containsKey(componentName)) {
                        component = componentMap.get(componentName);
                        if (canBeRemoved(componentName)) {
                            component.setStatus(Status.UNINSTALLED);
                            removeUnnecessaryComponents(componentName);
                        }
                        else {
                            Logger.stillNeeded(componentName);
                            component.setStatus(Status.IMPLICITLY_INSTALLED);
                        }
                    } else {
                        Logger.unknown(componentName);
                    }
                    break;
                case LIST:
                    listAllInstalledComponents();
                    break;
                case END:
                    // Do not do anything
                    break;
            }
        }
    }

    private void addDependency(String componentName, List<String> requiredComponentNames) {
        requiredComponentNames.forEach(requiredComponentName -> {
            Component requiredComponent = new Component(requiredComponentName);
            componentMap.put(requiredComponentName, requiredComponent);

            List<String> requiredForComponents;
            if (requiredForDependencyMap.containsKey(requiredComponentName)) {
                requiredForComponents = requiredForDependencyMap.get(requiredComponentName);
            }
            else {
                requiredForComponents = new ArrayList<>();
            }
            requiredForComponents.add(componentName);
            requiredForDependencyMap.put(requiredComponentName, requiredForComponents);
        });
        requiresDependencyMap.put(componentName, requiredComponentNames);
    }

    private void installRequiredComponentsFor(String componentName) {
        if (requiresDependencyMap.containsKey(componentName)) {
            List<String> requiredComponentNames = requiresDependencyMap.get(componentName);
            requiredComponentNames.forEach(requiredComponentName -> {
                installRequiredComponentsFor(requiredComponentName);
                componentMap.get(requiredComponentName).setStatus(Status.IMPLICITLY_INSTALLED);
            });
        }
    }

    private void listAllInstalledComponents() {
        componentMap.entrySet().stream()
                .filter(entry -> entry.getValue().isInstalled())
                .map(Map.Entry::getKey).sorted()
                .forEach(Logger::listInstalledComponent);
    }

    private boolean canBeRemoved(String componentName) {
        if (requiredForDependencyMap.containsKey(componentName)) {
            List<String> requiredForComponentNames = requiredForDependencyMap.get(componentName);
            int count = (int) requiredForComponentNames.stream()
                .filter(name -> componentMap.get(name).isInstalled()).count();

            return (count == 0);
        }
        return true;
    }

    private void removeUnnecessaryComponents(String componentName) {
        if (requiresDependencyMap.containsKey(componentName)) {
            List<String> requiresComponentNames = requiresDependencyMap.get(componentName);
            List<String> canBeRemovedComponentNames = requiresComponentNames.stream()
                    .filter(name -> componentMap.get(name).isImplicitlyInstalled())
                    .filter(this::canBeRemoved)
                    .collect(Collectors.toList());
            canBeRemovedComponentNames.forEach(name -> {
                componentMap.get(name).setStatus(Status.UNINSTALLED);
                removeUnnecessaryComponents(name);
            });
        }
    }
}
