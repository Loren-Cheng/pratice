package com.pratice.leetcode.arrays_and_strings;

import java.util.HashSet;

public class Leetcode_0003_longest_substring_without_repeating_characters_02 {
    public static int lengthOfLongestSubstring(String s) {
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> existStringSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if(!existStringSet.contains(s.charAt(j))){
                    existStringSet.add(s.charAt(j));
                }else {
                    break;
                }
            }
            if (existStringSet.size()>max){
                max = existStringSet.size();
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
