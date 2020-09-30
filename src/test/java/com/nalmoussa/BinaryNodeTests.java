package com.nalmoussa;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryNodeTests {
    @Test
    public void verifyIsLeafReturnTrueWhenNodeIsLeaf() {
        BinaryNode node = new BinaryNode(0);
        assertTrue("The method isLeaf() should return true when the node is a leaf.", node.isLeaf());
    }

    @Test
    public void verifyIsLeafReturnFalseWhenNodeIsNotLeaf() {
        BinaryNode node = new BinaryNode(0);
        node.right = new BinaryNode(0);
        assertFalse("The method isLeaf() should return false when the node is not a leaf.", node.isLeaf());
    }
}
