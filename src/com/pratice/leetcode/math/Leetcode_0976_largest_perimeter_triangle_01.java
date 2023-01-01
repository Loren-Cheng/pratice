package com.pratice.leetcode.math;

public class Leetcode_0976_largest_perimeter_triangle_01 {

    public int largestPerimeter(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && i != k && j != k) {
                        int tmpPremiter = nums[i] + nums[j] + nums[k];
                        if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[k] + nums[j] > nums[i] && tmpPremiter > max) max = tmpPremiter;
                    }
                }
            }
        }
        if(max>0) {
            return max;
        } else{
            return 0;
        }
    }
}
