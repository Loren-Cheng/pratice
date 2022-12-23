package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1790_CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int notEqualCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) notEqualCount++;
            if (notEqualCount > 2) return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) {
            return true;
        } else {
            return false;
        }
    }

}
