package com.pratice.leetcode.trees_and_graphs;

import java.util.*;

public class Leetcode_0752_open_the_lock_01 {
    public int openLock(String[] deadends, String target) {
        return bfs("0000", deadends, target);
    }

    int bfs(String origin, String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        int[][] directions = new int[][]{{1, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 0}, {0, -1, 0, 0}
                , {0, 0, 1, 0}, {0, 0, -1, 0}, {0, 0, 0, 1}, {0, 0, 0, -1}};
        int level = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(origin);
        seen.add(origin);

        for (String deadend : deadends
        ) {
            if (Objects.equals(deadend, origin)) {
                return -1;
            }
            seen.add(deadend);
        }

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                for (int[] direction : directions
                ) {
                    StringBuilder neighbor = new StringBuilder();
                    int count = node.length();
                    for (int j = 0; j < count; j++) {
                        int digit = Character.getNumericValue(node.charAt(j)) + direction[j];
                        if (digit == 10) {
                            digit = 0;
                        } else if (digit == -1) {
                            digit = 9;
                        }
                        neighbor.append(digit);
                    }
                    String stringNeighbor = neighbor.toString();
                    if (neighbor.length() == node.length() && !seen.contains(stringNeighbor)) {
                        for (String deadend : deadends
                        ) {
                            if (!seen.contains(stringNeighbor)
                                    && !stringNeighbor.equals(deadend)) {
                                seen.add(stringNeighbor);
                                queue.offer(stringNeighbor);
//                                System.out.println("level: " + level + ", neighbor: " + neighbor.toString());
                            }
                        }
                        if (stringNeighbor.equals(target)) {
                            return level;
                        }

                    }
                }
            }
        }
        return -1;
    }
}