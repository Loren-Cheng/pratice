package com.pratice.leetcode.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1_TwoSum_3 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int targetDeductNumAtI = target - nums[i];
            if (numsMap.containsKey(targetDeductNumAtI) && numsMap.get(targetDeductNumAtI) != i) {
                return new int[]{i, numsMap.get(targetDeductNumAtI)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));//[0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));//[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));//[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));//[1,2]
    }
}
