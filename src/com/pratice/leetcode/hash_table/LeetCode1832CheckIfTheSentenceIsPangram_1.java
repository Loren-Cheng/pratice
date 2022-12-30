package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class LeetCode1832CheckIfTheSentenceIsPangram_1 {
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        char a = 'a';

        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        for (int i = 0; i < 26; i++) {
            if(!set.contains(a++)){
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
