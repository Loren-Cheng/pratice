package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_2389_longest_subsequence_with_limited_sum_02 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = bst(prefixSum, queries[i]);
        }
        return ans;
    }

    int bst(int[] prefixSum, int target) {
        int left = 0;
        int right = prefixSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] <= target) {
                //bst from upper bound
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Math.min(left, prefixSum.length);
    }
}
