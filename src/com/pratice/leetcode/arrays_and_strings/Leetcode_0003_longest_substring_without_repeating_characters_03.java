package com.pratice.leetcode.arrays_and_strings;

import java.util.*;

public class Leetcode_0003_longest_substring_without_repeating_characters_03 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int right = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charMap.getOrDefault(s.charAt(i), 0) >= 1) {
                while (charMap.getOrDefault(s.charAt(i), 0) > 0) {
                    charMap.put(s.charAt(left), charMap.getOrDefault(s.charAt(i), 0) - 1);
                    left++;
                }
            }
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            right++;
            if ((right - left) > max) {
                max = right - left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring("aab"));//2
        System.out.println(lengthOfLongestSubstring("dvdf"));//3

    }
}
