package com.nalmoussa.coding.practice.problem033;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private final String name;
  private String value;
  private final List<Node> children;

  Node(String name) {
    this.name = name;
    this.value = null;
    this.children = new ArrayList<>();
  }

  void setValue(String value) {
    this.value = value;
  }

  void addChild(Node node) {
    this.children.add(node);
  }

  @Override
  public String toString() {
    // We want the node to look like this: {a, [{b, [{c, "foo"}, ... ]}, ...}
    String prefix = (value == null) ? name : String.format("%s, %s", name, value);
    String childrenToString = "";
    if (!children.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Node node : children) {
        stringBuilder.append(node);
        stringBuilder.append(" ");
      }

      childrenToString = String.format(", [%s]", stringBuilder.toString());
    }

    return String.format("{%s%s}", prefix, childrenToString);
  }
}
