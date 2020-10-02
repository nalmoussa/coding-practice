package com.nalmoussa.coding.practice.problem037;

class Component {
    private final String name;
    private Status status;

    Component(String name) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("Component name must be 10 characters or less");
        }
        this.name = name;
        this.status = Status.UNINSTALLED;
    }

    void setStatus(Status status) {
        switch (this.status) {
            case UNINSTALLED:
                logChangingUninstalledStatusTo(status);
                break;
            case EXPLICITLY_INSTALLED:
                logChangingInstalledStatusTo(status);
                break;
            case IMPLICITLY_INSTALLED:
                logChangingInstalledStatusTo(status);
                break;
        }
        this.status = status;
    }

    private void logChangingUninstalledStatusTo(Status status) {
        switch (status) {
            case UNINSTALLED:
                Logger.alreadyUninstalled(name);
                break;
            case EXPLICITLY_INSTALLED:
                Logger.install(name);
                break;
            case IMPLICITLY_INSTALLED:
                Logger.install(name);
                break;
        }
    }

    private void logChangingInstalledStatusTo(Status status) {
        switch (status) {
            case UNINSTALLED:
                Logger.remove(name);
                break;
            case EXPLICITLY_INSTALLED:
                Logger.alreadyInstalled(name);
                break;
            case IMPLICITLY_INSTALLED:
                // Do not log this
                break;
        }
    }

    boolean isInstalled() {
        return ((Status.EXPLICITLY_INSTALLED == status) || (Status.IMPLICITLY_INSTALLED == status));
    }

    boolean isImplicitlyInstalled() {
        return (Status.IMPLICITLY_INSTALLED == status);
    }
}
