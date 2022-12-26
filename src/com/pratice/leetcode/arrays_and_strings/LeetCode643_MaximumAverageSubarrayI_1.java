package com.pratice.leetcode.arrays_and_strings;

public class LeetCode643_MaximumAverageSubarrayI_1 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

}
