package com.pratice.leetcode.binary_search;

public class Leetcode_0035_search_insert_position_01 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(left, nums.length);
    }
}
