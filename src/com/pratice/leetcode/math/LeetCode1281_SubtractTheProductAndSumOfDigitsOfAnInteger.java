package com.pratice.leetcode.math;

public class LeetCode1281_SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        String[] stringN = String.valueOf(n).split("");
        int[] arrayN = new int[stringN.length];
        for(int i = 0; i < stringN.length; i++) {
            arrayN[i] = Integer.valueOf(stringN[i]);
        }
        for(int i = 0; i < arrayN.length; i++) {
            prod *= arrayN[i];
            sum += arrayN[i];
        }
        return (prod - sum);
    }
}
