package com.pratice.codeWars.string;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIncrement {

    public static void main(String[] args) {

        incrementString("foobar001");
        incrementString("foobar000");
        incrementString("foobar000000");
        incrementString("foobar000001");
        incrementString("foobar009");
        incrementString("foobar99");
        incrementString("foobar099");
        incrementString("b|Xq13143077096341");
        incrementString("foobar00999");
        incrementString("0<Xs.d.D2/FZt)000000000000000000000000000064579");
    }

    public static String incrementString(String str) {

        Pattern pattern = Pattern.compile(
                "0[1-9]{1}\\b|" +
                "[1-9]{2,}\\b|"+
                "[0-9]{1,}\\b|"
//                "0[1-9]{1}\\b|" +
//                        "[1-9]{2,}\\b|" +
//                        "00\\b|"+
//                        "0+\\b"
//                        "[^0-9]{1,}[9]{1,}"
//                        "[^0\\w]*0[1-9]*\\b|" +
//                        "[1-9]{2,}\\b|" +
        );
//                        "[1-9]{1,}\\b|"+
//                "[^0\\w]*[1-9]\\b|" +
//        Pattern pattern = Pattern.compile("[1-9]{2,}\\b|" );
        Matcher matcher = pattern.matcher(str);
        String num = "";
        StringBuilder output = new StringBuilder("");

        while (matcher.find()) {
            num += matcher.group();
        }
        System.out.println(str);
        System.out.println(num);
        String str1 = str.replace(num, "");
        String[] strArray = str1.split("");
        Stack<String> strStack = new Stack<>();
//        System.out.println("str1 : " + str1);
//        System.out.println("num : " + num);

        for (String e : strArray
        ) {
            strStack.add(e);
        }

        String tmpDecS = num;

        if (isNumeric(tmpDecS)) {
            long number = Long.parseLong(tmpDecS);
            System.out.println(number);
            if (tmpDecS.charAt(0) == '0' && number < 10) {
                switch ((int) number) {
                    case 0:
                        for (int i = 0; i < num.length() - 1; i++) {
                            strStack.add("0");
                        }
                        tmpDecS = Integer.toString(Integer.valueOf(tmpDecS) + 1);
                        strStack.add(tmpDecS);
                        break;
                    case 9:
                        int count = 0;
                        while(tmpDecS.charAt(0) == '0') {
                            tmpDecS = tmpDecS.replaceFirst("0", "");
                            count++;
                        }
                        for (int i = 0; i < count-1 ; i++) {
                            strStack.add("0");

                        }
                        tmpDecS = Integer.toString(Integer.valueOf(tmpDecS) + 1);
                        strStack.add(tmpDecS);
                        break;
                    default:
                        count = 0;
                        while(tmpDecS.charAt(0) == '0') {
                            tmpDecS = tmpDecS.replaceFirst("0", "");
                            count++;
                        }
                        for (int i = 0; i < count ; i++) {
                            strStack.add("0");

                        }
                        tmpDecS = Integer.toString(Integer.valueOf(tmpDecS) + 1);
                        strStack.add(tmpDecS);
                        break;
                }
            } else if ( tmpDecS.charAt(0) == '0'&tmpDecS.charAt(1) == '0' & number >= 10) {
                long count = 0;
                while(tmpDecS.charAt(0) == '0') {
                    tmpDecS = tmpDecS.replaceFirst("0", "");
                    count++;
                }
                for (int i = 0; i < count ; i++) {
                    strStack.add("0");

                }
                tmpDecS = Integer.toString(Integer.valueOf(tmpDecS) + 1);

                strStack.add(tmpDecS);
            } else {

                tmpDecS = Long.toString(Long.valueOf(tmpDecS) + 1);
                strStack.add(tmpDecS);
            }
        } else {
            strStack.add(tmpDecS);
            strStack.add("1");
        }

        strStack.forEach(s -> output.append(s));
        System.out.println(output);
        System.out.println();
        return output.toString(); // you code here

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

