package com.nalmoussa;

import java.util.ArrayList;
import java.util.List;

class WordLadder {
    // 1) Find all words in wordList that differ from beginWord by one character: transformedWords
    // 2) For each transformed word in transformedWords, construct new wordList without transformedWord
    // 3) Recursively, call findShortestTransformation(transformedWord, endWord, wordListWithoutTransformedWord)
    // 4) If the returned list isn't empty, add (beginWord + result) to the result
    // 5) Make sure you only keep the shortest lists
    static List<List<String>> findShortestTransformation(
            String beginWord,
            String endWord,
            List<String> wordList) {
        List<List<String>> transformations = new ArrayList<>();
        List<String> transformedWords = findAllTransformedWords(wordList, beginWord);
        if (!transformedWords.isEmpty()) {
            if (listContainsWord(transformedWords, endWord)) {
                List<String> sequence = new ArrayList<>();
                sequence.add(beginWord);
                sequence.add(endWord);
                transformations.add(sequence);
            } else {
                int shortestLength = Integer.MAX_VALUE;
                List<List<String>> innerTransformations;
                for (String transformedWord : transformedWords) {
                    List<String> wordListWithoutTransformedWord = excludeWordFromList(wordList, transformedWord);
                    innerTransformations = findShortestTransformation(transformedWord, endWord, wordListWithoutTransformedWord);
                    for (List<String> transformation : innerTransformations) {
                        int transformationSize = transformation.size();
                        if (transformationSize <= shortestLength) {
                            if (transformationSize < shortestLength) {
                                transformations.clear();
                                shortestLength = transformationSize;
                            }
                            transformation.add(0, beginWord);
                            transformations.add(transformation);
                        }
                    }
                }
            }
        }
        return transformations;
    }

    static List<String> excludeWordFromList(List<String> wordList, String word) {
        List<String> wordListWithoutWord = new ArrayList<>(wordList);
        wordListWithoutWord.remove(word);
        return wordListWithoutWord;
    }

    static boolean listContainsWord(List<String> transformedWords, String word) {
        for (String transformedWord : transformedWords) {
            if (transformedWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    static List<String> findAllTransformedWords(List<String> wordList, String word) {
        List<String> transformedWords = new ArrayList<>();
        for (String wordInList : wordList) {
            if (oneEditApart(wordInList, word)) {
                transformedWords.add(wordInList);
            }
        }
        return transformedWords;
    }

    static boolean oneEditApart(String word1, String word2) {
        int length = word1.length();
        int index = 0;
        while (index < length && (word1.charAt(index) == word2.charAt(index))) {
            index++;
        }
        if (index < length) {
            word1 = word1.substring(index+1);
            word2 = word2.substring(index+1);
            return word1.equals(word2);
        }

        return false;
    }
}

