package com.pratice.leetcode.arrays_and_strings;

public class LeetCode713_SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int curr = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod < k) {
                    curr++;
                } else {
                    prod = 1;
                    break;
                }

                if (j == nums.length - 1 ) {
                    prod = 1;
                    break;
                }
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode713_SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println();
        System.out.println(LeetCode713_SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2));
        System.out.println();
        System.out.println(LeetCode713_SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

}
