package com.pratice.leetcode.math;

public class Leetcode_1281_subtract_the_product_and_sum_of_digits_of_an_integer_02 {

    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        int digit = 0;

        while (n > 0) {
            digit = n % 10;
            prod *= digit;
            sum += digit;
            n /= 10;
        }
        return (prod - sum);
    }
}

