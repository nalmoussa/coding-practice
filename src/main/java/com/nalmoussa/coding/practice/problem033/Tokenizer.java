package com.nalmoussa.coding.practice.problem033;

class Tokenizer {
  private final TokenType[] types = {TokenType.BEGIN, TokenType.BEGIN, TokenType.BEGIN, TokenType.TEXT, TokenType.END,
                               TokenType.BEGIN, TokenType.END, TokenType.END, TokenType.BEGIN, TokenType.TEXT,
                               TokenType.END, TokenType.END};
  private final String[] values = {"a", "b", "c", "foo", "c", "c", "c", "b", "d", "blah", "d", "a"};

  private int index;

  Tokenizer() {
    index = 0;
  }

  Token nextToken() {
    Token token = null;
    if (index < values.length) {
      String value = values[index];
      TokenType type = types[index];
      token = new Token(value, type);

      index++;
    }

    return token;
  }
}
