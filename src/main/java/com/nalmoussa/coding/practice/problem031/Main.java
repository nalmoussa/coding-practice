package com.nalmoussa.coding.practice.problem031;

public class Main {
  public static void main(String[] args) {
  }

  Node getLCA(Node currentNode, Node node1, Node node2) {
    // Santize data

    if (((node1.value < currentNode.value) && (node2.value > currentNode.value)) ||
      ((node1.value > currentNode.value) && (node2.value < currentNode.value)) ||
      (node1.value.equals(currentNode.value)) || (node2.value.equals(currentNode.value))) {
    return currentNode;
    } else {
      currentNode = ((node1.value < currentNode.value) && (node2.value < currentNode.value)) ? currentNode.left : currentNode.right;
      return getLCA(currentNode, node1, node2);
    }
  }
}
