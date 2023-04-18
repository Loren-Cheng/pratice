package com.pratice.codeWars.string;

public class If_you_cant_sleep_01 {
    public static String countingSheep(int num) {
        //Add your code here
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= num; i++){
            sb.append(i).append(" sheep...");
        }
        return sb.toString();
    }
}
