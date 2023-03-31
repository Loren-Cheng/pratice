package com.pratice.leetcode.greedy;

import java.util.Arrays;

public class Leetcode_1196_how_many_apples_can_you_put_into_the_tasket_01 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < weight.length; i++) {
            sum += weight[i];
            if (sum > 5000) {
                break;
            }
            count++;
        }
        return count;
    }
}
