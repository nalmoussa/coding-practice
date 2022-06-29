package com.nalmoussa.coding.practice.problem048;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
  static class Node {
    private final int key;
    private final int value;
    private Node next;
    private Node prev;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = this;
      this.prev = this;
    }

    public int getKey() {
      return this.key;
    }

    public int getValue() {
      return this.value;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public Node getNext() {
      return this.next;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    public Node getPrev() {
      return this.prev;
    }
  }

  private final int capacity;
  private int count = 0;
  private final Map<Integer, Node> map;
  private Node mostRecentNode;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    if (this.map.containsKey(key)) {
      Node node = getExisting(key);
      removeExisting(node);
      putNewNode(key, node.getValue());
      return node.getValue();
    }

    return -1;
  }

  private Node getExisting(int key) {
    return this.map.get(key);
  }

  public void put(int key, int value) {
    if (this.map.containsKey(key)) {
      removeExisting(getExisting(key));
    } else if (count == capacity) {
      removeExisting(mostRecentNode.getNext());
    }

    putNewNode(key, value);
  }

  private void removeExisting(Node node) {
    Node prevNode = node.getPrev();
    Node nextNode = node.getNext();
    prevNode.setNext(nextNode);
    nextNode.setPrev(prevNode);
    this.map.remove(node.getKey());
    count--;

    if (mostRecentNode == node) {
      mostRecentNode = (this.map.isEmpty()) ? null : prevNode;
    }
  }

  private void putNewNode(int key, int value) {
    Node newNode = new Node(key, value);
    if (mostRecentNode != null) {
      Node leastRecentNode = mostRecentNode.getNext();
      leastRecentNode.setPrev(newNode);
      newNode.setPrev(mostRecentNode);
      newNode.setNext(leastRecentNode);
      mostRecentNode.setNext(newNode);
    }

    mostRecentNode = newNode;
    this.map.put(newNode.getKey(), newNode);
    count++;
  }
}
