package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1189_maximum_number_of_balloons_01 {
    public static int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> mapBalloon = new HashMap<>();
        Map<Character, Integer> mapText = new HashMap<>();
        for (int i = 0; i < balloon.length(); i++) {
            char curr = balloon.charAt(i);
            mapBalloon.put(curr, mapBalloon.getOrDefault(curr, 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            mapText.put(curr, mapText.getOrDefault(curr, 0) + 1);
        }
        for (int i = 0; i < balloon.length(); i++) {
            char curr = balloon.charAt(i);
            int currAtTextNum = mapText.getOrDefault(curr, 0);
            int currAtBalloonNum = mapBalloon.getOrDefault(curr, 0);
            if (currAtTextNum == 0) {
                return 0;
            }
            if ((currAtTextNum / currAtBalloonNum) < min) {
                min = currAtTextNum / currAtBalloonNum;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
