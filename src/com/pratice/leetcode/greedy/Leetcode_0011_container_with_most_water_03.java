package com.pratice.leetcode.greedy;

public class Leetcode_0011_container_with_most_water_03 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = (right - left) * Math.min(height[left], height[right]);
        while (right > left) {
            if (height[left] == Math.min(height[left], height[right])) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        }
        return max;//O(n)
    }
}
