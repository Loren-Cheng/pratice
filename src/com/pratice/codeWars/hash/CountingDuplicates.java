package com.pratice.codeWars.hash;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        text = text.toLowerCase();
        Map<Character, Integer> countMap = new HashMap();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char charAtI = text.charAt(i);
            int countAtChar = countMap.getOrDefault(charAtI, 0);
            countMap.put(charAtI, countAtChar += 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()
        ) {
            if (entry.getValue() > 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdeaBReturnsTwo"));
        System.out.println(duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
    }
}
