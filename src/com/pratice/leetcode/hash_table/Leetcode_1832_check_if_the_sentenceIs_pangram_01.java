package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode_1832_check_if_the_sentenceIs_pangram_01 {
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> azMap = new HashMap<>();
        char a = 'a';

        for (int i = 0; i < 26; i++) {
            azMap.put(a++, 0);
        }
        for (int i = 0; i < sentence.length(); i++) {
            azMap.put(sentence.charAt(i), azMap.get(sentence.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : azMap.entrySet()
        ) {
            if (entry.getValue() < 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
