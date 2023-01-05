package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1248_count_number_of_nice_subarrays_01 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int oddSum1 = 0;
        int counts = 0;
        Map<Integer, Integer> oddPrefixSumMap = new HashMap<>();
        oddPrefixSumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            oddSum1 += nums[i] % 2;
            counts += oddPrefixSumMap.getOrDefault(oddSum1 - k, 0);
            oddPrefixSumMap.put(oddSum1, oddPrefixSumMap.getOrDefault(oddSum1, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));//2
        //1, 1, 2, 1, 1
        //1, 2, 2, 3, 4
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));//16
        //{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}
        //{0, 0, 0, 1, 1, 1, 2, 2, 2, 2}
        System.out.println(numberOfSubarrays(new int[]{91473, 45388, 24720, 35841, 29648, 77363, 86290, 58032, 53752, 87188, 34428, 85343, 19801, 73201}, 4));//6
    }
}
