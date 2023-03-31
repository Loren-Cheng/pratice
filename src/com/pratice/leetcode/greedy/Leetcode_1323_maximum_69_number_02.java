package com.pratice.leetcode.greedy;

public class Leetcode_1323_maximum_69_number_02 {
    public static int maximum69Number(int num) {
        StringBuilder numSb = new StringBuilder();
        numSb.append(num);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numSb.length(); i++) {
            numSb = new StringBuilder();
            numSb.append(num);
            if (numSb.charAt(i) == '6') {
                numSb.setCharAt(i, '9');
            } else {
                numSb.setCharAt(i, '6');
            }
            max = Math.max(max, Integer.parseInt(numSb.toString()));
        }
        return Math.max(max, num);
    }


    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }
}
