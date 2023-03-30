package com.pratice.leetcode.heaps;

import java.util.*;

public class Leetcode_0692_top_k_frequent_words_01 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> counts = new HashMap<>();
        for(String word : words) {
            counts.put(word,counts.getOrDefault(word,0)+1);//O(n)
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (a,b)->{
                    if(counts.get(a) == counts.get(b)){
                        return b.compareTo(a);
                    } else {
                        return counts.get(a)-counts.get(b);
                    }
                }
        );
        List<String> ans = new ArrayList<>();
        for (String word:counts.keySet()
             ) {
            heap.offer(word);
            if(heap.size()>k){
                heap.poll();//O(n log(k))
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);//O(k)
        return ans;
    }
}
