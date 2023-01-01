package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_0202_contains_duplicate_01 {

    public static boolean isHappy(int n) {
        int sqr = 1;
        int Digit = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (true) {
            System.out.println("ini : " + n);
            sum = 0;
            Digit = n;
            System.out.println("String.valueOf(n).length() = " + String.valueOf(n).length());
            for (int i = 0; i < String.valueOf(n).length(); i++) {
                System.out.println("for " + i);
                sqr = (Digit % 10) * (Digit % 10);
                System.out.println(sqr);
                sum += sqr;
                Digit /= 10;
                if (i == String.valueOf(n).length() - 1) {
                    System.out.println("n   : " + n);
                    System.out.println("sum : " + sum);
                    if (sum == 1) {
                        return true;
                    }
                    if (map.containsKey(n)) {
                        return false;
                    }
                    map.putIfAbsent(n, sum);

                }
            }
            n = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

}
