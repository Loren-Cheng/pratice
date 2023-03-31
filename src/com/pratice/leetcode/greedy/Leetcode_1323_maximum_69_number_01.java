package com.pratice.leetcode.greedy;

import java.util.Arrays;

public class Leetcode_1323_maximum_69_number_01 {
    public static int maximum69Number(int num) {
        int tNum = num;
        int count = String.valueOf(num).length();
        int[] numArr = new int[count];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            numArr[i] = tNum % 10;
            tNum /= 10;
        }

        for (int i = 0; i < count; i++) {
            int[] tmpNum = Arrays.copyOf(numArr, count);
            if (tmpNum[i] == 9) {
                tmpNum[i] = 6;
            } else {
                tmpNum[i] = 9;
            }
            StringBuilder stringNum = new StringBuilder("");

            for (int j = count - 1; j >= 0; j--) {
                stringNum.append(tmpNum[j]);
            }
            max = Math.max(max, Integer.parseInt(stringNum.toString()));
        }
        return Math.max(max, num);
    }


    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));

    }
}
