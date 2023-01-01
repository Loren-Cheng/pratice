package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_2270_number_of_ways_to_split_array_01 {
    public static int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length];
        int waysCount = 0;
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
//            System.out.println("prefixSum[i] :" + prefixSum[i] + ", prefixSum[nums.length - 1] - prefixSum[i]:" + (prefixSum[nums.length - 1] - prefixSum[i]));
            if (prefixSum[i] >= (prefixSum[nums.length - 1] - prefixSum[i])) {
                waysCount++;
            }
        }
        return waysCount;
    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}));
    }
}
