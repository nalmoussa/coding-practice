package com.nalmoussa.coding.practice.problem001;

import java.util.Arrays;

public class FileSystem {
  private Directory root;

  public FileSystem() {
    this.root = new Directory("/");
  }

  // Example1: /a/b/c/d
  // Example2: /a
  public void mkdir(String path) {
    String[] directoryNames = getDirectoryNames(path);
    getOrMake(directoryNames);
  }

  public void addContentToFile(String filePath, String content) {
    String[] directoryNames = getDirectoryNames(filePath);
    String fileName = directoryNames[directoryNames.length - 1];
    directoryNames = Arrays.copyOf(directoryNames, directoryNames.length - 1);
    Directory directory = getOrMake(directoryNames);
    if (directory.existFile(fileName)) {
      content += directory.getFileContent(fileName);
    }
    directory.addFile(fileName, content);
  }

  public String readContentFromFile(String filePath) {
    String[] directoryNames = getDirectoryNames(filePath);
    String fileName = directoryNames[directoryNames.length - 1];
    directoryNames = Arrays.copyOf(directoryNames, directoryNames.length - 1);
    Directory directory = getOrMake(directoryNames);
    String content = "";
    if (directory.existFile(fileName)) {
      content = directory.getFileContent(fileName);
    }

    return content;
  }

  private Directory getOrMake(String[] directoryNames) {
    Directory currentDirectory = this.root;
    String currentPath;
    for (String directoryName : directoryNames) {
      currentPath = createNewPath(currentDirectory.getPath(), directoryName);
      if (currentDirectory.existDir(directoryName)) {
        currentDirectory = currentDirectory.getDir(directoryName);
      } else {
        Directory newDirectory = new Directory(currentPath);
        currentDirectory.addDir(directoryName, newDirectory);
        currentDirectory = newDirectory;
      }
    }
    return currentDirectory;
  }

  private static String[] getDirectoryNames(String path) {
    return (String[])Arrays.stream(path.split("/"))
        .filter(name -> !name.isEmpty())
        .toArray();
  }

  private static String createNewPath(String existingPath, String newPath) {
    if (existingPath.endsWith("/")) {
      int lastIndex = existingPath.lastIndexOf("/");
      existingPath = existingPath.substring(0, lastIndex);
    }

    if (newPath.startsWith("/")) {
      newPath = newPath.substring(1);
    }

    return existingPath.concat("/").concat(newPath);
  }

  public static void main(String[] args) {
    FileSystem fileSystem = new FileSystem();
    fileSystem.mkdir("/a//b//c/");
    fileSystem.mkdir("/a/b1/c/");
    fileSystem.mkdir("/a/b/c/d");
  }
}

