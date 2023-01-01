package com.pratice.leetcode.math;

import java.util.Arrays;

public class Leetcode_0976_largest_perimeter_triangle_02 {

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (a + b > c) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 2, 3};
        System.out.println(largestPerimeter(a));
    }
}
