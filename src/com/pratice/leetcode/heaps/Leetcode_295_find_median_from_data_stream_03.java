package com.pratice.leetcode.heaps;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_295_find_median_from_data_stream_03 {
    private List<Integer> list = new ArrayList<>();

    //    public MedianFinder() {
    public Leetcode_295_find_median_from_data_stream_03() {
    }

    public void addNum(int num) {
        int count = 0;
        for (int n:list
             ) {
            if(num>n){
                break;
            }
            count++;
        }
        if(list.size()!=0){
            list.add(count,num);
        }else{
            list.add(num);
        }
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

}
