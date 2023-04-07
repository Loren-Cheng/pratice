package com.pratice.leetcode.binary_search;

import java.util.Arrays;

public class Leetcode_0875_koko_eating_bananas_01 {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int[] copyPiles = Arrays.copyOf(piles, piles.length);
        int hours = h;

        while (left < right) {
            int mid = left + (right - left) / 2;
            for (int i = 0; i < copyPiles.length; i++) {
                while (hours > 0 && copyPiles[i] > 0) {
                    if (copyPiles[mid] > copyPiles[i]) {
                        --hours;
                        copyPiles[i] -= copyPiles[mid];
                    }
                }
                if (hours == 0 && copyPiles[i] > 0) {
                    copyPiles = Arrays.copyOf(piles, piles.length);
                    hours = h;
                    left = mid;
                    break;
                }
                if (hours >= 0 && i == copyPiles.length - 1 && copyPiles[i] <= 0) {
                    copyPiles = Arrays.copyOf(piles, piles.length);
                    hours = h;
                    right = mid +1;
                }
            }

        }

        return Math.min(left,piles[piles.length - 1]);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 7, 11};
        System.out.println(minEatingSpeed(a, 8));
        int[] b = new int[]{312884470};
        System.out.println(minEatingSpeed(b, 312884469));
        int[] c = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        System.out.println(minEatingSpeed(c, 823855818));//Time Limit Exceeded
    }
}
