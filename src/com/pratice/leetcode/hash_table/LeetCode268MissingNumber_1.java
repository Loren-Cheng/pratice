package com.pratice.leetcode.hash_table;

public class LeetCode268MissingNumber_1 {
    public static int missingNumber(int[] nums) {
        int predictSum = 0;
        int missingSum = 0;

        for (int i = 0; i <= nums.length; i++) {
            predictSum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            missingSum += nums[i];
        }
        return predictSum - missingSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }
}
