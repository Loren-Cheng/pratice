package com.pratice.leetcode.arrays_and_strings;

public class LeetCode1491_AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int s : salary) {
            max = s - max > 0 ? s : max;
            min = s < min ? s : min;
            sum += s;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
