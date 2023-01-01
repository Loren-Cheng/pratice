package com.pratice.leetcode.arrays_and_strings;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0239_sliding_window_maximum_01 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> win = new LinkedList<>();
        int max = Integer.MIN_VALUE;;

        for (int i = 0; i < k; i++) {
            win.add(nums[i]);
        }

        for (int i : win) {
            max = Math.max(i, max);
        }
        ans[0] = max;
        for (int i = k; i < nums.length; i++) {
            max = Integer.MIN_VALUE;
            win.pop();
            win.add(nums[i]);
            for (int j : win
            ) {
                max = Math.max(j, max);
            }
            ans[i - k + 1] = max;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1},1 )));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3 )));
    }
}
