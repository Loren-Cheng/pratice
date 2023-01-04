package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1941_check_if_all_characters_have_equal_number_of_occurrences_01 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        for (char c : ss) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counts = map.get(ss[0]);
        for (char c : map.keySet()) {
            if (map.get(c) - counts != 0) {
                return false;
            }
        }
        return true;
    }
}
