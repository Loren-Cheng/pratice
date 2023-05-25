package com.pratice.codeWars.mathmatics;

public class Adding_big_numbers {
    public static String add(String a, String b) {
        //The input numbers are big.
        //The input is a string of only digits
        //The numbers are positives

        //先以int[]裝反轉的num，
        int[] arrA = new int[a.length() + 1];
        int[] arrB = new int[b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            arrA[i] = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - i)));
        }
        for (int i = 0; i < b.length(); i++) {
            arrB[i] = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - i)));
        }
        int count = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
        int[] ans = new int[count];
        int next = 0;
        for (int i = 0; i < ans.length; i++) {
            int crrA = 0;
            int crrB = 0;

            if (i < a.length()) {
                crrA = arrA[i];
            }
            if (i < b.length()) {
                crrB = arrB[i];
            }
            if (crrA + crrB + next > 9) {
                ans[i] = crrA + crrB - 10 + next;
                next = 1;
            } else {
                ans[i] = crrA + crrB + next;
                next = 0;
            }
        }
        StringBuilder stringAnsBuilder = new StringBuilder();
        boolean begPrint = false;
        for (int i = 0; i < ans.length; i++) {
            if (ans[ans.length - 1 - i] != 0) {
                begPrint = true;
            }
            if (begPrint) {
                stringAnsBuilder.append(ans[ans.length - 1 - i]);
            }

        }
        return stringAnsBuilder.toString();
    }

    public static void main(String[] args) {
//        add("12", "23");
//        add("888","222");
//        add("8","2");
        String a = "97164960167590";
        String b = "056175187760661789023212";
        int[] arrA = new int[a.length() + 1];
        int[] arrB = new int[b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            arrA[i] = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - i)));
        }
        for (int i = 0; i < b.length(); i++) {
            arrB[i] = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - i)));
        }
        int count = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
//        int count = Math.max(a.length(), b.length()) + 1;
        int[] ans = new int[count];
        int next = 0;
        for (int i = 0; i < ans.length; i++) {
            int crrA = 0;
            int crrB = 0;

            if (i < a.length()) {
                crrA = arrA[i];
            }
            if (i < b.length()) {
                crrB = arrB[i];
            }
            if (crrA + crrB + next > 9) {
                ans[i] = crrA + crrB - 10 + next;
                next = 1;
            } else {
                ans[i] = crrA + crrB + next;
                next = 0;
            }
        }

        StringBuilder stringAnsBuilder = new StringBuilder();
        boolean begPrint = false;
        for (int i = 0; i < ans.length; i++) {
            if (ans[ans.length - 1 - i] != 0) {
                begPrint = true;
            }
            if (begPrint) {
                stringAnsBuilder.append(ans[ans.length - 1 - i]);
            }

        }
//        System.out.println("a: " + Arrays.toString(arrA));
//        System.out.println("b: " + Arrays.toString(arrB));
//        System.out.println("ans: " + Arrays.toString(newAns));
        System.out.println(stringAnsBuilder.toString());
    }
}
