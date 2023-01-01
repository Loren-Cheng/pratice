package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_0342_reverse_string_01 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        int leftP;
        int rightP;
        for (int i = 0; i < nums.length; i++) {
            leftP = (int) Math.pow(nums[left], 2);
            rightP = (int) Math.pow(nums[right], 2);
            if (leftP > rightP) {
                ans[nums.length - i - 1] = leftP;
                left++;
            } else {
                ans[nums.length - i - 1] = rightP;
                right--;
            }
        }
        return ans;
    }
}
