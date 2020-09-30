package com.nalmoussa;

class Pair<K, V> {
  private final K k;
  private final V v;

  Pair(K k, V v) {
    this.k = k;
    this.v = v;
  }

  K getKey() {
    return k;
  }

  V getValue() {
    return v;
  }
}
