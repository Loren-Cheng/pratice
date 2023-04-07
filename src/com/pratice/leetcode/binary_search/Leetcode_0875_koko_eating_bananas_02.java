package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_0875_koko_eating_bananas_02 {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int[] copyPiles = Arrays.copyOf(piles, piles.length);

        int left = 1;
        int right = piles[piles.length - 1];
        while (left < right) {
            int hours = 0;
            int mid = left + (right - left) / 2;
            for (int i = 0; i < piles.length; i++) {
                System.out.println(Math.ceil((double) piles[i] / mid));
                hours += Math.ceil((double) piles[i] / mid);
            }
            System.out.println("hours: " + hours + ", mid: " + mid);
            if (hours <= h) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return Math.min(left, max);
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
