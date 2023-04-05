package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_2300_successful_pairs_of_spells_and_potions_01 {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            ans[i] = potions.length - bstLowerBound(success, spells[i], potions);
        }
        return ans;
    }

    static int bstLowerBound(long target, int prod, int[] potions) {
        int left = 0;
        int right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (1L * potions[mid] * prod >= target) {
                //max of potions[i]*spells[i] will be 10^5*10^5 ~= 10 >int => cast to long
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(left, potions.length);
    }

    public static void main(String[] args) {
        int[] s1 = new int[]{5, 1, 3};
        int[] p1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(successfulPairs(s1, p1, 7)));
    }
}
