package com.pratice.leetcode.hash_table;

public class Leetcode_1189_maximum_number_of_balloons_03 {
    public static int maxNumberOfBalloons(String text) {
        char[] balloonArray = new char[]{'b', 'a', 'l', 'o', 'n'};
        int min = Integer.MAX_VALUE;
        char[] textArray = text.toCharArray();
        int[] counts = new int[26];
        for (int c : textArray) {
            ++counts[c - 'a'];
        }
        for (int c : balloonArray) {
            if (c == 'l' || c == 'o') {
                counts[c - 'a'] = (counts[c - 'a'] / 2);
            }
            min = Math.min(min, counts[c - 'a']);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
