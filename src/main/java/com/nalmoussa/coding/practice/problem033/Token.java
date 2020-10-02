package com.nalmoussa.coding.practice.problem033;

class Token {
  private final String value;
  private final TokenType type;

  Token(String value, TokenType type) {
    this.value = value;
    this.type = type;
  }

  String getValue() {
    return this.value;
  }

  TokenType getType() {
    return this.type;
  }

  @Override
  public String toString() {
    // We want the token to look like this: (BEGIN, “a”)
    return String.format("(%s, \"%s\")", type, value);
  }
}
