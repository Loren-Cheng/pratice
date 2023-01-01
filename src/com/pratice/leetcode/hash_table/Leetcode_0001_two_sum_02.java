package com.pratice.leetcode.hash_table;

import java.util.*;

public class Leetcode_0001_two_sum_02 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashSet<Integer> numsSet = new HashSet<>();
        int containsCounts = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(target - nums[i])) {
                containsCounts++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(containsCounts>2){
                if(nums[i] != target - nums[i]){
                    if (numsSet.contains(target - nums[i])) {
                        ans[count++] = i;
                    }
                }
            } else if (numsSet.contains(target - nums[i])) {
                ans[count++] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));//[0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));//[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));//[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5}, -8)));//[1,2]
    }
}
