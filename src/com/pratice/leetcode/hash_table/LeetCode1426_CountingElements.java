package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class LeetCode1426_CountingElements {
    public static int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int counts = 0;
        for (int e: arr
             ) {
            set.add(e);
        }
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]+1)){
                counts++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,2,3}));
    }
}
