package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_0953_verifying_an_alien_dictionary_01 {
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderNum = new HashMap<>();
        int count = 0;
        for (int i = 0; i < order.length(); i++) {
            count++;
            orderNum.put(order.charAt(i), count);
        }
        for (int i = 0; i < words.length - 1; i++) {
            int wordCount = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < wordCount; j++) {
                char wordICharAtJ = words[i].charAt(j);
                char wordI1CharAtJ = words[i + 1].charAt(j);
                if (orderNum.get(wordICharAtJ) < orderNum.get(wordI1CharAtJ)) {
                    break;
                } else if (orderNum.get(wordICharAtJ) > orderNum.get(wordI1CharAtJ)) {
                    return false;
                }
                if (j == wordCount - 1 && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));

    }
}
