package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_0344_reverse_string_01 {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
