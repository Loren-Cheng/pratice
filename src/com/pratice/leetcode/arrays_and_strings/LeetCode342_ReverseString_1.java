package com.pratice.leetcode.arrays_and_strings;

public class LeetCode342_ReverseString_1 {
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

