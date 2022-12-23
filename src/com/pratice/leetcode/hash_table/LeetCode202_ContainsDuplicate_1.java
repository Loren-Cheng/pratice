package com.pratice.leetcode.hash_table;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202_ContainsDuplicate_1 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = new LeetCode202_ContainsDuplicate_1().calSqrSumOfOfN(n);
            if (sum == 1) return true;
            if (set.contains(n)) return false;
            set.add(n);
            n = sum;
        }
    }

    protected int calSqrSumOfOfN(int n) {
        int sum = 0;
        int count = String.valueOf(n).length();
        for (int i = 0; i < count; i++) {
            int sqr = (n % 10) * (n % 10);
            sum += sqr;
            n /= 10;
        }
        return sum;
    }

    public void main(String[] args) {
        System.out.println(isHappy(7));
        System.out.println();
        System.out.println(isHappy(19));
        System.out.println();
        System.out.println(isHappy(2));
    }

}
