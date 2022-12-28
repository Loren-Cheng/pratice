package com.pratice.leetcode.arrays_and_strings;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LeetCode424_LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        HashSet<Character> dic = new LinkedHashSet<>();
        int right;
        int left;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            dic.add(s.charAt(i));
        }
        for (char c : dic) {
            int discrtCounts = 0;
            right = 0;
            left = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    discrtCounts++;
                }
                right++;
                if (discrtCounts > k) {
                    while (discrtCounts != k) {
                        if (s.charAt(left) != c) {
                            discrtCounts--;
                        }
                        left++;
                    }
                }
                if ((right - left) > max) {
                    max = right - left;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));//4
        System.out.println(characterReplacement("AABABBA", 1));//4
        System.out.println(characterReplacement("AAAB", 0));//3
        System.out.println(characterReplacement("ABAA", 0));//2
        System.out.println(characterReplacement("SJDMETRJSDSSMESSTR", 2));//6
    }
}
