package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class Leetcode_1426_counting_elements_01 {
    public static int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int counts = 0;
        for (int e: arr
             ) {
            set.add(e);
        }
        for (int j : arr) {
            if (set.contains(j + 1)) {
                counts++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,2,3}));
    }
}
