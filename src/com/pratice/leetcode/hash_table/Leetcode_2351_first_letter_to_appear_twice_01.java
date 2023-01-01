package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class Leetcode_2351_first_letter_to_appear_twice_01 {
    public static char repeatedCharacter(String s) {
        HashSet<Character> characterHashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!characterHashSet.contains(s.charAt(i))) {
                characterHashSet.add(s.charAt(i));
            } else {
                return s.charAt(i);
            }
        }
        return 'z';
    }

    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
    }
}
