package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class Leetcode_1832_check_if_the_sentenceIs_pangram_03 {
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
