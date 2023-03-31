package com.pratice.leetcode.greedy;

public class Leetcode_0011_container_with_most_water_04 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int hLeft = height[left];
        int hRight = height[right];
        while (right > left) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                while (height[left] <= hLeft && left < right) {
                    left++;
                }
                hLeft = height[left];
            } else {
                while (height[right] <= hRight && left < right) {
                    right--;
                }
                hRight = height[right];
            }
        }
        return max;
    }
}
