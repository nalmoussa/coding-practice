package com.nalmoussa.coding.practice.problem037;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/com/nalmoussa/problems/dependency/input.txt";

    public static void main(String[] args) throws Exception {
        String inputFileName = (args.length > 0) ? args[0] : INPUT_FILE_NAME;
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.readInputFromFile(inputFileName);
        commandExecutor.execute();
        commandExecutor.writeOutputToFile();
    }
}
