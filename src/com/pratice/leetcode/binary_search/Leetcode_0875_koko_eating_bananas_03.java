package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_0875_koko_eating_bananas_03 {
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;//取max O(n)，不用sorting整個array
        for (int n : piles
        ) {
            max = Math.max(max, n);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int hours = 0;
            int mid = left + (right - left) / 2;
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) hours++;
                //用整數除法小數被取整跟處理取整數時少加餘數計算來替換cast to double的運算量及double除法的運算量
            }
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 7, 11};
        System.out.println(minEatingSpeed(a, 8));
        int[] b = new int[]{312884470};
        System.out.println(minEatingSpeed(b, 312884469));
        int[] c = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        System.out.println(minEatingSpeed(c, 823855818));//Time Limit Exceeded
        int[] d = new int[]{30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(d, 6));//23
    }
}
