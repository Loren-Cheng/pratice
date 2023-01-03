package com.pratice.leetcode.hash_table;

import java.util.*;

public class Leetcode_2248_intersection_of_multiple_arrays_01 {
    public static List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums[0].length; i++) {
            map.put(nums[0][i],1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {
            if(entry.getValue()==nums.length){
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}}));
    }
}
