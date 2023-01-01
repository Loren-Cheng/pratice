package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_0977_squares_of_a_sorted_array_02 {
    public int[] sortedSquares(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[lo]) > Math.abs(nums[hi])) {
                ans[nums.length - i - 1] = nums[lo] * nums[lo];
                lo++;
            } else {
                ans[nums.length - i - 1] = nums[hi] * nums[hi];
                hi--;
            }
        }
        return ans;
    }
}
