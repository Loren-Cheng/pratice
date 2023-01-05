package com.pratice.leetcode.hash_table;

public class Leetcode_1248_count_number_of_nice_subarrays_02 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int oddSum = 0;
        int counts = 0;
        int tmpLeft = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                oddSum++;
            }
            if (oddSum > k & k != 0) {
                left = tmpLeft;
                oddSum--;
            }
            if (oddSum == k) {
                tmpLeft = left;
                while (true) {
                    counts++;
                    if (nums[tmpLeft] % 2 != 1) {
                        tmpLeft++;
                    } else {
                        tmpLeft++;
                        break;
                    }
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));//2
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));//16
        System.out.println(numberOfSubarrays(new int[]{91473, 45388, 24720, 35841, 29648, 77363, 86290, 58032, 53752, 87188, 34428, 85343, 19801, 73201}, 4));//6
    }
}
