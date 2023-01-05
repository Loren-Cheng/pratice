package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_0560_subarray_sum_equals_k_01 {
    public static int subarraySum(int[] nums, int k) {
        int counts = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            counts += prefixSum.getOrDefault(sum - k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));//2
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));//2
        System.out.println(subarraySum(new int[]{1}, 0));//0
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));//2
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));//1
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));//2
    }
}
