package com.pratice.leetcode.hash_table;

import java.util.HashSet;

public class Leetcode_0268_missing_number_01 {
    public static int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }
}
