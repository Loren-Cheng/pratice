package com.pratice.leetcode.arrays_and_strings;

import java.util.Arrays;

public class Leetcode_1502_can_make_arithmetic_progression_from_sequence_01 {
    //1502. Can Make Arithmetic Progression From Sequence
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 2] - arr[i + 1] != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}
