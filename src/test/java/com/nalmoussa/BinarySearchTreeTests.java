package com.nalmoussa;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTests {
    @Test
    public void verifyPrintWithInOrderTraversalOrderIterativelyShowsNothingWhenRootIsNull() {
        verifyPrintWithInOrderTraversalOrderShowsNothingWhenRootIsNull(true);
    }

    @Test
    public void verifyPrintWithLevelTraversalOrderIterativelyShowsNothingWhenRootIsNull() {
        verifyPrintWithLevelTraversalOrderShowsNothingWhenRootIsNull(true);
    }

    @Test
    public void verifyPrintWithPostOrderTraversalOrderIterativelyShowsNothingWhenRootIsNull() {
        verifyPrintWithPostOrderTraversalOrderShowsNothingWhenRootIsNull(true);
    }

    @Test
    public void verifyPrintWithPreOrderTraversalOrderIterativelyShowsNothingWhenRootIsNull() {
        verifyPrintWithPreOrderTraversalOrderShowsNothingWhenRootIsNull(true);
    }

    @Test
    public void verifyPrintWithInOrderTraversalOrderIterativelyWorksAsExpected() {
        verifyPrintWithInOrderTraversalOrderWorksAsExpected(true);
    }

    @Test
    public void verifyPrintWithLevelTraversalOrderIterativelyWorksAsExpected() {
        verifyPrintWithLevelTraversalOrderWorksAsExpected(true);
    }

    @Test
    public void verifyPrintWithPostOrderTraversalOrderIterativelyWorksAsExpected() {
        verifyPrintWithPostOrderTraversalOrderWorksAsExpected(true);
    }

    @Test
    public void verifyPrintWithPreOrderTraversalOrderIterativelyWorksAsExpected() {
        verifyPrintWithPreOrderTraversalOrderWorksAsExpected(true);
    }

    @Test
    public void verifyPrintWithInOrderTraversalOrderRecursivelyShowsNothingWhenRootIsNull() {
        verifyPrintWithInOrderTraversalOrderShowsNothingWhenRootIsNull(false);
    }

    @Test
    public void verifyPrintWithLevelTraversalOrderRecursivelyShowsNothingWhenRootIsNull() {
        verifyPrintWithLevelTraversalOrderShowsNothingWhenRootIsNull(false);
    }

    @Test
    public void verifyPrintWithPostOrderTraversalOrderRecursivelyShowsNothingWhenRootIsNull() {
        verifyPrintWithPostOrderTraversalOrderShowsNothingWhenRootIsNull(false);
    }

    @Test
    public void verifyPrintWithPreOrderTraversalOrderRecursivelyShowsNothingWhenRootIsNull() {
        verifyPrintWithPreOrderTraversalOrderShowsNothingWhenRootIsNull(false);
    }

    @Test
    public void verifyPrintWithInOrderTraversalOrderRecursivelyWorksAsExpected() {
        verifyPrintWithInOrderTraversalOrderWorksAsExpected(false);
    }

    @Test
    public void verifyPrintWithLevelTraversalOrderRecursivelyWorksAsExpected() {
        verifyPrintWithLevelTraversalOrderWorksAsExpected(false);
    }

    @Test
    public void verifyPrintWithPostOrderTraversalOrderRecursivelyWorksAsExpected() {
        verifyPrintWithPostOrderTraversalOrderWorksAsExpected(false);
    }

    @Test
    public void verifyPrintWithPreOrderTraversalOrderRecursivelyWorksAsExpected() {
        verifyPrintWithPreOrderTraversalOrderWorksAsExpected(false);
    }

    @Test
    public void verifyInsertShouldNotThrowExceptionWhenInputIsNull() {
        boolean hasException = false;
        try {
            BinarySearchTree tree = new BinarySearchTree();
            tree.insert(null);
        }
        catch (Exception ex) {
            hasException = true;
        }

        assertFalse("The method insert() should not throw exception if the input array is null", hasException);
    }

    @Test
    public void verifyHeightReturnsZeroWhenRootIsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals("The method height() should return 0 when the root is null.", 0, tree.height());
    }

    @Test
    public void verifyHeightReturnsZeroWhenRootIsLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(0);
        assertEquals("The method height() should return 0 when the root is leaf.", 0, tree.height());
    }

    @Test
    public void verifyHeightReturnsNodeCountMinusOneWhenTreeIsDegenerate() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {1, 2, 3, 4, 5};
        tree.insert(nodes);
        int expected = nodes.length - 1;
        int actual = tree.height();
        assertEquals("The method height() should return the number of nodes minus one when the tree is degenerate.", expected, actual);
    }

    @Test
    public void verifyHeightReturnsTheCorrectHeightWhenTreeIsBalanced() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {4, 2, 6, 1, 3, 5, 7};
        tree.insert(nodes);
        int expected = 2;
        int actual = tree.height();
        assertEquals("The method height() should return the correct height when the tree is balanced.", expected, actual);
    }

    @Test
    public void verifyDepthReturnsZeroWhenRootIsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals("The method depth() should return 0 when the root is null.", 0, tree.depth());
    }

    @Test
    public void verifyDepthReturnsZeroWhenRootIsLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(0);
        assertEquals("The method depth() should return 0 when the root is leaf.", 0, tree.depth());
    }

    @Test
    public void verifyDepthReturnsNodeCountMinusOneWhenTreeIsDegenerate() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {1, 2, 3, 4, 5};
        tree.insert(nodes);
        int expected = nodes.length - 1;
        int actual = tree.depth();
        assertEquals("The method depth() should return the number of nodes minus one when the tree is degenerate.", expected, actual);
    }

    @Test
    public void verifyDepthReturnsTheCorrectDepthWhenTreeIsBalanced() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {4, 2, 6, 1, 3, 5, 7};
        tree.insert(nodes);
        int expected = 2;
        int actual = tree.depth();
        assertEquals("The method depth() should return the correct depth when the tree is balanced.", expected, actual);
    }

    @Test
    public void verifyHeightAndDepthAreTheSame() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {4, 2, 6, 1, 3, 5, 7};
        tree.insert(nodes);
        int height = tree.height();
        int depth = tree.depth();
        assertEquals("The methods height() and depth() should return the same value.", height, depth);
    }

    @Test
    public void verifyDiameterReturnsZeroWhenRootIsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals("The method diameter() should return 0 when the root is null.", 0, tree.diameter());
    }

    @Test
    public void verifyDiameterReturnsZeroWhenRootIsLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(0);
        assertEquals("The method diameter() should return 0 when the root is leaf.", 0, tree.diameter());
    }

    @Test
    public void verifyDiameterReturnsNodeCountMinusOneWhenTreeIsDegenerate() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {1, 2, 3, 4, 5};
        tree.insert(nodes);
        int expected = nodes.length - 1;
        int actual = tree.diameter();
        assertEquals("The method diameter() should return the number of nodes minus one when the tree is degenerate.", expected, actual);
    }

    @Test
    public void verifyDiameterReturnsTheCorrectDiameterWhenTreeIsBalanced() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {4, 2, 6, 1, 3, 5, 7};
        tree.insert(nodes);
        int expected = 4;
        int actual = tree.diameter();
        assertEquals("The method diameter() should return the correct diameter when the tree is balanced.", expected, actual);
    }

    @Test
    public void verifyDiameterReturnsTheCorrectDiameterWhenTreeIsUnbalanced() {
        BinarySearchTree bigTree = new BinarySearchTree();
        int[] nodesForBigTree = {20, 21, 4, 3, 2, 1, 5, 6, 7};
        bigTree.insert(nodesForBigTree);

        BinarySearchTree smallTree = new BinarySearchTree();
        int[] nodesForSmallTree = {4, 3, 2, 1, 5, 6, 7};
        smallTree.insert(nodesForSmallTree);

        int bigTreeDiameter = bigTree.diameter();
        int smallTreeDiameter = smallTree.diameter();
        assertEquals("The method diameter() should return the correct diameter when the tree is unbalanced.", bigTreeDiameter, smallTreeDiameter);
    }

    @Test
    public void countUniqueTreesShouldReturnZeroWhenInputIsNegative() {
        int n = -4;
        int expected = 0;
        int actual = BinarySearchTree.countUniqueTrees(n);
        assertEquals("The method countUniqueTrees(n) should return 0 if n is negative", expected, actual);

        actual = BinarySearchTree.countUniqueTreesFast(n);
        assertEquals("The method countUniqueTreesFast(n) should return 0 if n is negative", expected, actual);
    }

    @Test
    public void countUniqueTreesShouldReturnOneWhenInputIsZero() {
        int n = 0;
        int expected = 1;
        int actual = BinarySearchTree.countUniqueTrees(n);
        assertEquals("The method countUniqueTrees(n) should return 1 if n is zero", expected, actual);

        actual = BinarySearchTree.countUniqueTreesFast(n);
        assertEquals("The method countUniqueTreesFast(n) should return 1 if n is zero", expected, actual);
    }

    @Test
    public void countUniqueTreesShouldReturn5WhenInputIs3() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 5, 14, 42};
        int actual, n;
        for (int i = 0; i < input.length; i++) {
            n = input[i];
            actual = BinarySearchTree.countUniqueTrees(n);
            assertEquals("The method countUniqueTrees(n) returns incorrect value when n = ", expected[i], actual);

            actual = BinarySearchTree.countUniqueTreesFast(n);
            assertEquals("The method countUniqueTreesFast(n) returns incorrect value when n = ", expected[i], actual);
        }
    }

    private void verifyPrintWithInOrderTraversalOrderShowsNothingWhenRootIsNull(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.IN_ORDER, mockPrinter, traverseIteratively);
        boolean nothingWasPrinted = mockPrinter.getPrintedValues().length == 0;
        assertTrue("The method print() with IN_ORDER Traversal Order should not print anything when the root is null", nothingWasPrinted);
    }

    private void verifyPrintWithLevelTraversalOrderShowsNothingWhenRootIsNull(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.LEVEL, mockPrinter, traverseIteratively);
        boolean nothingWasPrinted = mockPrinter.getPrintedValues().length == 0;
        assertTrue("The method print() with LEVEL Traversal Order should not print anything when the root is null", nothingWasPrinted);
    }

    private void verifyPrintWithPostOrderTraversalOrderShowsNothingWhenRootIsNull(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.POST_ORDER, mockPrinter, traverseIteratively);
        boolean nothingWasPrinted = mockPrinter.getPrintedValues().length == 0;
        assertTrue("The method print() with POST_ORDER Traversal Order should not print anything when the root is null", nothingWasPrinted);
    }

    private void verifyPrintWithPreOrderTraversalOrderShowsNothingWhenRootIsNull(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.PRE_ORDER, mockPrinter, traverseIteratively);
        boolean nothingWasPrinted = mockPrinter.getPrintedValues().length == 0;
        assertTrue("The method print() with PRE_ORDER Traversal Order should not print anything when the root is null", nothingWasPrinted);
    }

    private void verifyPrintWithInOrderTraversalOrderWorksAsExpected(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {5, 3, 1, 2, 4, 7, 6, 8};
        tree.insert(nodes);
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.IN_ORDER, mockPrinter, traverseIteratively);
        int[] expected =  {1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = mockPrinter.getPrintedValues();
        assertArrayEquals("The method print() with IN_ORDER Traversal Order should work as expected", expected, actual);
    }

    private void verifyPrintWithLevelTraversalOrderWorksAsExpected(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {5, 3, 1, 2, 4, 7, 6, 8};
        tree.insert(nodes);
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.LEVEL, mockPrinter, traverseIteratively);
        int[] expected =  {5, 3, 7, 1, 4, 6, 8, 2};
        int[] actual = mockPrinter.getPrintedValues();
        assertArrayEquals("The method print() with LEVEL Traversal Order should work as expected", expected, actual);
    }

    private void verifyPrintWithPostOrderTraversalOrderWorksAsExpected(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {5, 3, 1, 2, 4, 7, 6, 8};
        tree.insert(nodes);
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.POST_ORDER, mockPrinter, traverseIteratively);
        int[] expected =  {2, 1, 4, 3, 6, 8, 7, 5};
        int[] actual = mockPrinter.getPrintedValues();
        assertArrayEquals("The method print() with POST_ORDER Traversal Order should work as expected", expected, actual);
    }

    private void verifyPrintWithPreOrderTraversalOrderWorksAsExpected(boolean traverseIteratively) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nodes = {5, 3, 1, 2, 4, 7, 6, 8};
        tree.insert(nodes);
        BinaryNodeMockPrinter mockPrinter = new BinaryNodeMockPrinter();
        tree.print(TraversalOrder.PRE_ORDER, mockPrinter, traverseIteratively);
        int[] expected =  {5, 3, 1, 2, 4, 7, 6, 8};
        int[] actual = mockPrinter.getPrintedValues();
        assertArrayEquals("The method print() with PRE_ORDER Traversal Order should work as expected", expected, actual);
    }
}
