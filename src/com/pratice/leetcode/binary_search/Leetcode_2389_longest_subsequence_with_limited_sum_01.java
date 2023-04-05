package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_2389_longest_subsequence_with_limited_sum_01 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] copyNums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            copyNums[i] = sum;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = copyNums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (copyNums[mid] <= queries[i]) {
                    //bst from upper bound
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left < copyNums.length) {
                ans[i] = left;
            } else {
                ans[i] = copyNums.length;
            }
        }
        return ans;
    }
}
