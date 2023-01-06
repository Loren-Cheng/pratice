package com.pratice.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_2260_minimum_consecutive_cards_to_pick_up_02 {
    public static int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                int distance = i - map.get(cards[i]) + 1;
                min = Math.min(min,distance);
            }
            map.put(cards[i], i);
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));//4
        System.out.println(minimumCardPickup(new int[]{1, 0, 5, 3}));//-1
    }
}
