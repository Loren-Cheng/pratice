package com.pratice.leetcode.heaps;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_295_find_median_from_data_stream_04 {
    private List<Integer> list = new ArrayList<>();

    //    public MedianFinder() {
    public Leetcode_295_find_median_from_data_stream_04() {
    }

    public void addNum(int num) {
        int bound = lower_bound(list, num);
        list.add(bound, num);
    }

    public double findMedian() {
        int size = list.size();
        int count = size / 2;
        if (size % 2 == 0) {

            return (list.get(count - 1) + list.get(count)) / 2.0;
        } else {
            return list.get(count);
        }
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
