package com.nalmoussa.coding.practice.problem040;

/*
Your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
	['c', 'c', 'c', 'a', 'r', 's'],
	['c', 'c', 'i', 't', 'n', 'b'],
	['a', 'c', 'n', 'n', 't', 'i'],
	['t', 'c', 'i', 'i', 'p', 't']
]

word1_1 = "catnip"
find_word_location(grid1, word1_1)-> [ (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 4) ]

word1_2 = "cccc"
find_word_location(grid1, word1_2)-> [(0, 1), (1, 1), (2, 1), (3, 1)]
OR [(0, 0), (1, 0), (1, 1), (2, 1)]
OR [(0, 0), (0, 1), (1, 1), (2, 1)]
OR [(1, 0), (1, 1), (2, 1), (3, 1)]


grid2 = [
    ['c', 'p', 'a', 'n', 't', 's'],
    ['a', 'b', 'i', 't', 'a', 'b'],
    ['t', 'f', 'n', 'n', 'c', 'i'],
    ['x', 's', 'c', 'a', 't', 'n'],
    ['x', 's', 'd', 'd', 'e', 'a'],
    ['s', 'q', 'w', 'x', 's', 'p']
]


word2 = "catnap"
find_word_location(grid2, word2)-> [ (3, 2), (3, 3), (3, 4), (3, 5), (4, 5), (5, 5) ]

grid3 = [
    ['c', 'r', 'c', 'a', 'r', 's'],
    ['a', 'b', 'i', 't', 'n', 'i'],
    ['t', 'f', 'n', 'n', 'x', 'p'],
    ['x', 's', 'i', 'x', 'p', 't']]
word3 = "catnip"
find_word_location(grid3, word3)-> [ (0, 2), (0, 3), (1, 3), (1, 4), (1, 5), (2, 5) ]

n = number of rows
m = number of columns
w = length of the word
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmbeddedWords {
    public static void main(String[] argv) {
        firstQuestion();
        System.out.println("=====");
        secondQuestion();
    }

    private static void firstQuestion() {
        String[] words = {"cat", "baby", "dog", "times"};
        String word1 = "bbyasdf";
        String word2 = "nptica";
        String word3 = "seemati";
        String word4 = "ccccc";
        String word5 = "falafel";

        System.out.println(find_embedded_word(words, word1));
        System.out.println(find_embedded_word(words, word2));
        System.out.println(find_embedded_word(words, word3));
        System.out.println(find_embedded_word(words, word4));
        System.out.println(find_embedded_word(words, word5));
    }

    private static void secondQuestion() {
        char[][] grid1 = {
                {'c', 'c', 'c', 'a', 'r', 's'},
                {'c', 'c', 'i', 't', 'n', 'b'},
                {'a', 'c', 'n', 'n', 't', 'i'},
                {'t', 'c', 'i', 'i', 'p', 't'}
        };
        String word1_1 = "catnip";
        String word1_2 = "cccc";

        char[][] grid2 = {
                {'c', 'p', 'a', 'n', 't', 's'},
                {'a', 'b', 'i', 't', 'a', 'b'},
                {'t', 'f', 'n', 'n', 'c', 'i'},
                {'x', 's', 'c', 'a', 't', 'n'},
                {'x', 's', 'd', 'd', 'e', 'a'},
                {'s', 'q', 'w', 'x', 's', 'p'}
        };
        String word2 = "catnap";

        char[][] grid3 = {
                {'c','r','c','a','r','s'},
                {'a','b','i','t','n','i'},
                {'t','f','n','n','x','p'},
                {'x','s','i','x','p','t'}
        };
        String word3 = "catnip";

        printWordLocation(find_word_location(grid1, word1_1, 0, 0));
        printWordLocation(find_word_location(grid1, word1_2, 0, 0));
        printWordLocation(find_word_location(grid2, word2  , 0, 0));
        printWordLocation(find_word_location(grid3, word3  , 0, 0));
    }

    private static String find_embedded_word(String[] words, String str) {
        String result = "None";
        List<Map<String, Integer>> wordsMap = createWordsMap(words);
        Map<String, Integer> strMap = createWordMap(str);

        for (int i = 0; i < wordsMap.size(); i++) {
            if (isEmbedded(wordsMap.get(i), strMap)) {
                result = words[i];
                break;
            }
        }

        return result;
    }

    private static List<Map<String, Integer>> createWordsMap(String[] words) {
        List<Map<String, Integer>> resultList = new ArrayList<>();
        for (String word : words) {
            resultList.add(createWordMap(word));
        }

        return resultList;
    }

    private static Map<String, Integer> createWordMap(String word) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String ch = word.substring(i, i+1);
            int count = wordMap.getOrDefault(ch, 0);
            count++;
            wordMap.put(ch, count);
        }

        return wordMap;
    }

    private static boolean isEmbedded(Map<String, Integer> wordMap, Map<String, Integer> strMap) {
        for (String key : wordMap.keySet()) {
            int valueFromWord = wordMap.get(key);
            int valueFromStr = strMap.getOrDefault(key, -1);

            if (valueFromWord > valueFromStr) {
                return false;
            }
        }
        return true;
    }

    private static int[][] find_word_location(char[][] grid, String word, int firstRow, int firstCol) {
        for (int row = firstRow; row < grid.length; row++) {
            for (int col = firstCol; col < grid[0].length; col++) {
                char ch = grid[row][col];
                if (ch == word.charAt(0)) {
                    if (word.length() == 1) {
                        int[][] result = new int[1][2];
                        result[0][0] = firstRow;
                        result[0][1] = firstCol;
                        return result;
                    }
                    int[] firstPair = {row, col};
                    int[][] result = find_word_location(grid, word.substring(1), row, col + 1);
                    if ((result != null) && areAdjacent(firstPair, result[0])) {
                        return concat(firstPair, result);
                    }
                    result = find_word_location(grid, word.substring(1), row + 1, col);
                    if ((result != null) && areAdjacent(firstPair, result[0])) {
                        return concat(firstPair, result);
                    }
                }
            }
        }

        return null;
    }

    private static boolean areAdjacent(int[] firstPair, int[] secondPair) {
        boolean rightMoveByOne = (firstPair[0] == secondPair[0]) && (firstPair[1] == secondPair[1] - 1);
        boolean downMoveByOne = (firstPair[0] == secondPair[0] - 1) && (firstPair[1] == secondPair[1]);
        return rightMoveByOne || downMoveByOne;
    }

    private static int[][] concat(int[] firstPair, int[][] pairs) {
        int[][] result = new int[pairs.length + 1][2];
        result[0] = firstPair;
        System.arraycopy(pairs, 0, result, 1, result.length - 1);

        return result;
    }

    private static void printWordLocation(int[][] location) {
        if (location == null) {
            return;
        }

        System.out.print("[");
        for (int[] ch : location) {
            System.out.print("(" + ch[0] + "," + ch[1] + ") ");
        }
        System.out.println("]");
    }
}
