package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_1962_remove_stones_to_minimize_the_total_02 {
    public int minStoneSum(int[] piles, int k) {
        //Time Limit Exceeded
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int n:piles
             ) {
            list.add(n);
            sum+=n;
        }
        Collections.sort(list);//O(n log(n))
        for (int i = 0; i < k; i++) {
            int count = piles.length-1;
            int num = list.get(count);
            list.remove(count);
            int flo = (int) Math.floor(num / 2.0);
            int aft = num - flo;
            int index = lower_bound(list,aft);//O(k* log(n))
            sum -= flo;
            list.add(index,aft);
        }
        return sum;
    }

    int lower_bound(List<Integer> list, int key) {
        // Initialize starting index and
        // ending index
        int low = 0, high = list.size();
        int mid;

        // Till high does not crosses low
        while (low < high) {

            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= list.get(mid)) {
                high = mid;
            }

            // If key is greater than array[mid],
            // then find in right subarray
            else {
                low = mid + 1;
            }
        }

        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < list.size() && list.get(low) < key) {
            low++;
        }

        // Returning the lower_bound index
        return low;
    }
}
