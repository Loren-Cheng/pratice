package com.pratice.leetcode.hash_table;

import java.io.FileNotFoundException;
import java.util.*;

public class Leetcode_0049_group_anagrams_02 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] alp = new int[26];
        for (String s : strs) {
            Arrays.fill(alp, 0);
            for (char c : s.toCharArray()) {
                alp[c - 'a']++;
            }
            String hash = Arrays.toString(alp);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));//["bat"],["nat","tan"],["ate","eat","tea"]
        System.out.println(groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"}));//["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]

    }
}
