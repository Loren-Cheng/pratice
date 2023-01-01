package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_1480_running_sum_of_1d_array_01 {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;
    }
}
