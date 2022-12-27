package com.pratice.leetcode.arrays_and_strings;

import java.util.*;

public class LeetCode3_LongestSubstringWithoutRepeatingCharacters_2 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> existCharMap = new HashMap<>();
        int right = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (existCharMap.getOrDefault(s.charAt(i), 0) >= 1) {
                while (existCharMap.getOrDefault(s.charAt(i), 0) > 0) {
                    existCharMap.put(s.charAt(left), existCharMap.getOrDefault(s.charAt(i), 0) - 1);
                    left++;
                }
            }
            existCharMap.put(s.charAt(i), existCharMap.getOrDefault(s.charAt(i), 0) + 1);
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
