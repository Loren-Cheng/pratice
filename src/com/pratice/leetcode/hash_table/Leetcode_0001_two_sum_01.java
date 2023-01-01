package com.pratice.leetcode.hash_table;

import java.util.Arrays;

public class Leetcode_0001_two_sum_01 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]) == target) {
                        ans[0] = Math.min(i,j);
                        ans[1] = Math.max(i,j);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));//[0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));//[1,2]
    }
}
