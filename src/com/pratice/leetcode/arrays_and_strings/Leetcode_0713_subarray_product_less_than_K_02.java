package com.pratice.leetcode.arrays_and_strings;

public class Leetcode_0713_subarray_product_less_than_K_02 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k && left < right) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(LeetCode713_SubarrayProductLessThanK_1.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
//        System.out.println();
//        System.out.println(LeetCode713_SubarrayProductLessThanK_1.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
//        System.out.println();
//        System.out.println(LeetCode713_SubarrayProductLessThanK_1.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2));
//        System.out.println();
//        System.out.println(LeetCode713_SubarrayProductLessThanK_1.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
        System.out.println(Leetcode_0713_subarray_product_less_than_K_02.numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18));
        System.out.println();
    }
}
