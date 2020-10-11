package com.nalmoussa.coding.practice.problem043;

// Dog {
//   p1 Dog,
//   p2 Dog
// }

// Implement a method taking two dogs as inputs, and return a bool indicating whether these two dogs are generic related.
// Dogs are generic related if they have any common ancestor.
// We can assume there’s no circular reference.
//  g
// / \
// a b    e
// \ /\    \
//  c  f   d

import java.util.HashSet;
import java.util.Set;

class DogCommonAncestors {
  public static void main(String[] args) {
    Dog a = new Dog("a");
    Dog b = new Dog("b");
    Dog c = new Dog("c");
    Dog d = new Dog("d");
    Dog e = new Dog("e");
    Dog f = new Dog("f");

    c.leftParent = a;
    c.rightParent = b;
    f.leftParent = b;
    d.leftParent = e;

    System.out.println(hasCommonAncestor(c, f));
    System.out.println(hasCommonAncestor(e, f));
    System.out.println(hasCommonAncestor(e, d));
  }

  private static boolean hasCommonAncestor(Dog dog1, Dog dog2) {
    if (dog1 == null || dog2 == null) {
      return false;
    }

    Set<Dog> ancestors1 = getAncestor(dog1);
    Set<Dog> ancestors2 = getAncestor(dog2);
    ancestors1.add(dog1);
    ancestors2.add(dog2);

    return hasCommonElements(ancestors1, ancestors2);
  }

  private static Set<Dog> getAncestor(Dog dog) {
    Set<Dog> set = new HashSet<>();

    if (dog != null) {
      if (dog.leftParent != null) {
        set.add(dog.leftParent);
        set.addAll(getAncestor(dog.leftParent));
      }
      if (dog.rightParent != null) {
        set.add(dog.rightParent);
        set.addAll(getAncestor(dog.rightParent));
      }
    }

    return set;
  }

  private static boolean hasCommonElements(Set<Dog> ancestors1, Set<Dog> ancestors2) {
    for (Dog dog : ancestors1) {
      if (ancestors2.contains(dog)) {
        return true;
      }
    }

    return false;
  }
}