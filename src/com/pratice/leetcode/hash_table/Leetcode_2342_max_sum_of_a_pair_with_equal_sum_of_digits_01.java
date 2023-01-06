package com.pratice.leetcode.hash_table;

import java.util.HashMap;

public class Leetcode_2342_max_sum_of_a_pair_with_equal_sum_of_digits_01 {
    public static int maximumSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int n = nums[i];
            while (n % 10 != 0 || n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (map.containsKey(sum)) {
                int preSumNum = map.get(sum);
                int currMax = Integer.MIN_VALUE;

                max = Math.max(max, preSumNum + nums[i]);
                currMax = Math.max(preSumNum, nums[i]);
                map.put(sum, currMax);
            } else {
                map.put(sum, nums[i]);
            }
        }

        if (max != Integer.MIN_VALUE) {
            return max;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{463, 409, 477, 288}));
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));//54
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));//-1
        System.out.println(maximumSum(new int[]{279, 169, 463, 252, 94, 455, 423, 315, 288, 64, 494, 337, 409, 283, 283, 477, 248, 8, 89, 166, 188, 186, 128}));//872
//        int[] a = new int[]{279, 169, 463, 252, 94, 455, 423, 315, 288, 64, 494, 337, 409, 283, 283, 477, 248, 8, 89, 166, 188, 186, 128};
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < a.length; i++) {
//            map.put(872 - a[i], a[i]);
//        }
//        //463,409(true)
//        //477,288(false)
//        for (int i = 0; i < a.length; i++) {
//            if (map.containsKey(872 - a[i])) {
//                if (872 - a[i] - map.getOrDefault(a[i],0) == 0) {
//                    System.out.println(map.get(a[i]));
//                    System.out.println(a[i]);
//                }
//            }
//        }
    }
}
