package com.pratice.leetcode.hash_table;

public class Leetcode_1189_maximum_number_of_balloons_02 {
    public static int maxNumberOfBalloons(String text) {
        int bCounts = 0;
        int aCounts = 0;
        int lCounts = 0;
        int oCounts = 0;
        int nCounts = 0;
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if ('b' == curr) {
                bCounts++;
            } else if ('a' == curr) {
                aCounts++;
            } else if ('l' == curr) {
                lCounts++;
            } else if ('o' == curr) {
                oCounts++;
            } else if ('n' == curr) {
                nCounts++;
            }
        }
        lCounts = lCounts / 2;
        oCounts = oCounts / 2;

        return Math.min(bCounts, Math.min(aCounts, Math.min(lCounts, Math.min(oCounts, nCounts))));
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
