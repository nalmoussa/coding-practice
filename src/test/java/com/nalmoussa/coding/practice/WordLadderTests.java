package com.nalmoussa.coding.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordLadderTests {
    @Test
    public void verifyOneEditApartWorksAsExpected() {
        String[] word1 = {"hot", "hot", "hot", "a", "abcd", ""};
        String[] word2 = {"got", "hit", "how", "b", "abcd", ""};
        boolean[] expectedReturn = {true, true, true, true, false, false};
        boolean areTheyOneEditApart;
        String message;
        int length = 6;
        for (int i = 0; i < length; i++) {
            areTheyOneEditApart = WordLadder.oneEditApart(word1[i], word2[i]);
            message = String.format("WordLadder.oneEditApart(%s, %s) returned %s, but this should be %s",
                    word1[i], word2[i], areTheyOneEditApart, expectedReturn[i]);
            Assert.assertEquals(message, expectedReturn[i], areTheyOneEditApart);
        }
    }

    @Test
    public void verifyListContainsWordWorksAsExpected() {
        String[] array = {"got", "hit", "how", "b", "abcd", ""};
        List<String> list = Arrays.asList(array);
        String[] word = {"", "hot", "hit", null, "b"};
        boolean[] expectedReturn = {true, false, true, false, true};
        boolean found;
        String message;
        int length = 5;
        for (int i = 0; i < length; i++) {
            found = WordLadder.listContainsWord(list, word[i]);
            message = String.format("WordLadder.listContainsWord(%s, %s) returned %s, but this should be %s",
                    Arrays.toString(array), word[i], found, expectedReturn[i]);
            Assert.assertEquals(message, expectedReturn[i], found);
        }
    }

    @Test
    public void verifyFindAllTransformedWordsWorksAsExpected() {
        String[] array = {"got", "hit", "how", "fit", "abc", "cba", "get", "hot"};
        List<String> list = Arrays.asList(array);
        String[] word = {"get", "hot", "xyz"};
        int[] expectedSizes = {1, 3, 0};
        int size;
        int length = 3;
        String message;
        for (int i = 0; i < length; i++) {
            size = WordLadder.findAllTransformedWords(list, word[i]).size();
            message = String.format("WordLadder.findAllTransformedWords(%s, %s) returned %d elements, but this should be %d",
                    Arrays.toString(array), word[i], size, expectedSizes[i]);
            Assert.assertEquals(message, expectedSizes[i], size);
        }
    }

    @Test
    public void verifyExcludeWordFromListWorksAsExpected() {
        String[] array = {"got", "hit", "how"};
        String[] expectedArray = {"hit", "how"};
        List<String> list = Arrays.asList(array);
        List<String> expectedList = Arrays.asList(expectedArray);
        String word = "got";
        List<String> wordListWithoutWord = WordLadder.excludeWordFromList(list, word);
        String message = String.format("WordLadder.excludeWordFromList(%s, %s) returned %s, but this should be %s",
                Arrays.toString(array), word, Arrays.toString(wordListWithoutWord.toArray()), Arrays.toString(expectedArray));
        Assert.assertEquals(message, expectedList, wordListWithoutWord);
        Assert.assertEquals("WordLadder.excludeWordFromList() changed the size of the original list", 3, list.size());
    }

    @Test
    public void verifyFindShortestTransformationWorksAsExpected() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] array = {"hot", "dot", "dog", "lot", "log", "xyz"};
        List<String> wordList = Arrays.asList(array);
        String rowMessage = "WordLadder.findShortestTransformation(%s, %s, %s) returned %d Transformation(s), but this should be %d";
        List<List<String>> transformations = WordLadder.findShortestTransformation(beginWord, endWord, wordList);
        String message = String.format(rowMessage, beginWord, endWord, Arrays.toString(array), transformations.size(), 0);
        Assert.assertEquals(message, 0, transformations.size());

        array[5] = "cog"; // {"hot","dot","dog","lot","log", "cog"}
        wordList = Arrays.asList(array);
        transformations = WordLadder.findShortestTransformation(beginWord, endWord, wordList);
        message = String.format(rowMessage, beginWord, endWord, Arrays.toString(array), transformations.size(), 2);
        Assert.assertEquals(message, 2, transformations.size());
        String[] expectedTransformation = {"hit", "hot", "dot", "dog", "cog"};
        Assert.assertArrayEquals("Some Message", expectedTransformation, transformations.get(0).toArray());
    }
}
