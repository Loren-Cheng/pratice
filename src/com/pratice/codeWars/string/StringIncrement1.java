package com.pratice.codeWars.string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StringIncrement1 {

    public static void main(String[] args) {
//        incrementString("Ipq<x_)+_<ESA>G1?4Rq$C^#pD\"0000000000000000000000000001024210039");
        incrementString("Hsm)gpyCVS+FvB_F`C.A#80579568661");
        incrementString("fo99obar99");
        incrementString("foobar099");
        incrementString("");
        incrementString("foobar009");
        incrementString("foobar99");
        incrementString("foobar001");
        incrementString("foobar000");
        incrementString("foobar000000");
        incrementString("foobar000001");
        incrementString("b|Xq13143077096341");
        incrementString("foobar00999");
        incrementString("0<Xs.d.D2/FZt)000000000000000000000000000064579");
    }

    public static String incrementString(String str) {

        StringBuilder output = new StringBuilder("");
        Stack<String> strStack = new Stack<>();
        String num = attratchNum(str);

        for (int i = 0; i < str.length(); i++) {
            strStack.add(Character.toString(str.charAt(i)));
        }

        for (int i = 0; i < num.length(); i++) {
            strStack.pop();
        }

        strStack.forEach(s -> output.append(s));

        numAppend0ToOuput(num, output, is0X9X(num));

        System.out.println(str + "---" + (output.toString() + numberAddOne(num)));
        return output.toString() + numberAddOne(num); // you code here
    }

    public static boolean is0X9X(String num) {
        char pri = '9';
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == pri) {
                if (i == 0) {
                    return true;
                }
            } else if (num.charAt(i) == '0' && pri == '9') {
                pri = '0';
                if (i == 0) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static void numAppend0ToOuput(String num, StringBuilder output, boolean is0X9X) {
        if (is0X9X) {
            for (int i = 0; i < num.length(); i++) {
                if (i <= num.length() - 2) {
                    if (num.charAt(i) == '0' && num.charAt(i + 1) == '0') {
                        output.append('0');
                    }
                }
            }
        } else {
            for (int i = 0; i < num.length(); i++) {
                if (i <= num.length() - 2) {
                    if (num.charAt(i) == '0') {
                        output.append('0');
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static String numberAddOne(String num) {
        try {
            if (num.isEmpty()) {
                num = "0";
            }
            return Long.toString(Long.parseLong(num) + 1);
        } catch (Exception e) {
            BigInteger bigNum = new BigInteger(num);
            return bigNum.add(BigInteger.valueOf(1l)).toString();
        }
    }

    public static String attratchNum(String str) {
        ArrayList<Character> num = new ArrayList<>();
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            char lastChar = str.charAt(str.length() - 1 - i);

            if (Character.isDigit(lastChar)) {
                num.add(lastChar);
            } else {
                break;
            }
        }
        Collections.reverse(num);
        for (int i = 0; i < num.size(); i++) {
            output.append(num.get(i));
        }
        return output.toString();
    }

}

