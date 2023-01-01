package com.pratice.leetcode.arrays_and_strings;

import java.util.*;

public class Leetcode_0239_sliding_window_maximum_02 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> win = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            win.add(nums[i]);
            max = Math.max(nums[i], max);
        }
        ans[0] = max;
        for (int i = k; i < nums.length; i++) {
            max = Integer.MIN_VALUE;
            int tmp = win.pop();
            win.add(nums[i]);

            if (ans[i - k] > tmp) {
                max = Math.max(nums[i], ans[i - k]);
            } else {
                max = Collections.max(win);
            }
            ans[i - k + 1] = max;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));//[3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{2, 4, 7}, 2)));//[4, 7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));//[3,3,2,5]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
        int[] a = new int[10000 + 1 + 9995];
        int b = 10000;
        for (int i = 0; i < a.length; i++) {
            a[i] = b--;
        }
        System.out.println(Arrays.toString(maxSlidingWindow(a, 10007)));
    }
}
