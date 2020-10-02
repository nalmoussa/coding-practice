package com.nalmoussa.coding.practice.problem037;

import java.util.ArrayList;
import java.util.List;

class Logger {
    private static final String INSTALLING = "  Installing %s";
    private static final String REMOVING = "  Removing %s";
    private static final String STILL_NEEDED = "  %s is still needed.";
    private static final String UNKNOWN = "  %s is unknown.";
    private static final String ALREADY_INSTALLED = "  %s is already installed.";
    private static final String ALREADY_UNINSTALLED = "  %s is not installed.";
    private static final String SHIFT = "  %s";

    private static final List<String> LOGS = new ArrayList<>();
    private Logger() {}

    static void remove(String name) {
        LOGS.add(String.format(REMOVING, name));
    }

    static void alreadyInstalled(String name) {
        LOGS.add(String.format(ALREADY_INSTALLED, name));
    }

    static void alreadyUninstalled(String name) {
        LOGS.add(String.format(ALREADY_UNINSTALLED, name));
    }

    static void install(String name) {
        LOGS.add(String.format(INSTALLING, name));
    }

    static void stillNeeded(String name) {
        LOGS.add(String.format(STILL_NEEDED, name));
    }

    static void unknown(String name) {
        LOGS.add(String.format(UNKNOWN, name));
    }

    static void listInstalledComponent(String name) {
        LOGS.add(String.format(SHIFT, name));
    }

    static void log(String line) {
        LOGS.add(line);
    }

    static List<String> getLogs() {
        return LOGS;
    }

}
