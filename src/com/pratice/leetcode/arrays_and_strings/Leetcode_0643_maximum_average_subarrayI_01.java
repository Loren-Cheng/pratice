package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_0643_maximum_average_subarrayI_01 {
    public static double findMaxAverage(int[] nums, int k) {
        double avg = 0.0;
        for (int i = 0; i < k; i++) {
            avg += nums[i];
            if (i == k - 1) {
                avg /= k;
            }
        }
        int left = k;
        double max = avg;
        for (int i = k; i < nums.length; i++) {
            avg -= nums[i - k] * 1.0 / k;
            avg += nums[i] * 1.0 / k;
            if (avg > max) {
                max = avg;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

}
