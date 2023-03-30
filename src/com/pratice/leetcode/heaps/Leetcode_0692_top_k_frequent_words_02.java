package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_0692_top_k_frequent_words_02 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);//O(n)
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> {
                    if (counts.get(a) == counts.get(b)) {
                        return b.compareTo(a);
                        //次數相同時，字典序後的的在上面(先被poll()掉，留下字典序較前的)
                    } else {
                        return counts.get(a) - counts.get(b);
                        //次數少的在上面。
                    }
                }
        );
        List<String> ans = new ArrayList<>(k);
        for (String word : counts.keySet()
        ) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();//~= OR <= O(n log(k))
            }
        }
        String[] ansArr = new String[k];
        for (int i = 0; i < k; i++) {
            ansArr[i] = heap.poll();//O(k)
        }
        for (int i = k - 1; i >= 0; i--) {
            ans.add(ansArr[i]);//O(k)
        }
        return ans;
    }
}
