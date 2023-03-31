package com.pratice.leetcode.greedy;

public class Leetcode_0011_container_with_most_water_01 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * Math.abs(i - j), max);//O(n^2)
            }
        }
        return max;
    }
}
