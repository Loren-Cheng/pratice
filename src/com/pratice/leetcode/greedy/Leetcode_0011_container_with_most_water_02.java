package com.pratice.leetcode.greedy;

public class Leetcode_0011_container_with_most_water_02 {
    public int maxArea(int[] height) {
        int hi = height[0];
        int hj = height[height.length-1];
        int max = (height.length - 1) * Math.min(hi, hj);
        for (int i = 0; i < height.length; i++) {
            hj = height[height.length-1];
            if (height[i] >= hi) {
                for (int j = height.length - 1; j > i; j--) {
                    if (height[j] >= hj) {
                        max = Math.max(Math.min(height[i], height[j]) * Math.abs(i - j), max);//O(n^2)
                    }
                    hj = Math.max(height[j],hj);
                }
            }
            hi = Math.max(height[i],hi);
        }
        return max;
    }
}
