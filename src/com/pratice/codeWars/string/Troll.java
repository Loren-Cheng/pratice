package com.pratice.codeWars.string;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Troll {
    public static String disemvowel(String str) {
        // Code away...
        Pattern pattern = Pattern.compile("[AaEeIiOoUu]");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            str = str.replaceFirst("[AaEeIiOoUu]","");
        }
        return  str;
    }
}
