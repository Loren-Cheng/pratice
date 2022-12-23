package com.pratice.leetcode.hash_table;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1790_CheckIfOneStringSwapCanMakeStringsEqual_1 {

    public boolean areAlmostEqual(String s1, String s2) {
        int notEqualCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) notEqualCount++;
            if (notEqualCount > 2) return false;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
            set2.add(s2.charAt(i));
        }
        if (set1.equals(set2)) {
            return true;
        } else {
            return false;
        }
    }

}
