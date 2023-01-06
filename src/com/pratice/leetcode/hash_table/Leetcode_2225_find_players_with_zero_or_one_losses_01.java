package com.pratice.leetcode.hash_table;

import java.util.*;

public class Leetcode_2225_find_players_with_zero_or_one_losses_01 {
    public static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> lists0 = new ArrayList<>();
        List<Integer> lists1 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            if (0 == entry.getValue()) {
                lists0.add(entry.getKey());
            } else if (1 == entry.getValue()) {
                lists1.add(entry.getKey());
            }
        }
        Collections.sort(lists0);
        Collections.sort(lists1);
        ans.add(lists0);
        ans.add(lists1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));
    }
}
