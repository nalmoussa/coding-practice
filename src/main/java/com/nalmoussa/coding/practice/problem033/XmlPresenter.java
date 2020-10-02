package com.nalmoussa.coding.practice.problem033;

import java.util.Stack;

/*
You are provided with a set of APIs for reading an XML document.
You’re tasked with designing and implementing an API to represent the hierarchical structure of XML.
Your API should capture all the values found in an XML document, including tag names and texts

<a>
  <b>
    <c>foo</c>
    <c></c>
  </b>
  <d>blah</d>
</a>

(BEGIN, “a”), (BEGIN, “b”), (BEGIN, “c”), (TEXT, “foo”), (END, “c”)...
*/
public class XmlPresenter {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        Node root = parse(tokenizer);
        System.out.println(root);
    }

    static Node parse(Tokenizer tokenizer) {
        Node node = null;
        Stack<Node> tokenStack = new Stack<>();
        Token token = tokenizer.nextToken();
        while (token != null) {
            switch (token.getType()) {
                case BEGIN:
                    tokenStack.push(new Node(token.getValue()));
                    break;
                case TEXT:
                    node = tokenStack.pop();
                    node.setValue(token.getValue());
                    tokenStack.push(node);
                    break;
                case END:
                    node = tokenStack.pop();
                    if (!tokenStack.empty()) {
                        Node parent = tokenStack.pop();
                        parent.addChild(node);
                        tokenStack.push(parent);
                    }
                    break;
            }
            token = tokenizer.nextToken();
        }
        return node;
    }
}
