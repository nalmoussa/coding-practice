package com.nalmoussa.coding.practice.filesystem;

import java.util.HashMap;
import java.util.Map;

public class Directory {
  private String path;
  Map<String, String> files;
  Map<String, Directory> directories;

  Directory(String path) {
    this.path = path;
    this.files = new HashMap<>();
    this.directories = new HashMap<>();
  }

  public Directory getDir(String directoryName) {
    return directories.get(directoryName);
  }

  public void addDir(String directoryName, Directory newDirectory) {
    this.directories.put(directoryName, newDirectory);
  }

  public boolean existDir(String directoryName) {
    return this.directories.containsKey(directoryName);
  }

  public String getFileContent(String fileName) {
    return files.get(fileName);
  }

  public void addFile(String fileName, String content) {
    this.files.put(fileName, content);
  }

  public boolean existFile(String fileName) {
    return this.files.containsKey(fileName);
  }

  public String getPath() {
    return this.path;
  }
}
