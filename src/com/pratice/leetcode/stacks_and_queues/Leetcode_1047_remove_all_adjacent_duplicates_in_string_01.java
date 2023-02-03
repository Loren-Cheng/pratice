package com.pratice.leetcode.stacks_and_queues;

import java.util.Stack;

public class Leetcode_1047_remove_all_adjacent_duplicates_in_string_01 {
    public static String removeDuplicates(String s) {
        Stack<Character> ans = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (ans.empty()) {
                ans.push(s.charAt(i));
            } else {
                if (ans.peek() == s.charAt(i)) {
                    ans.pop();
                } else {
                    ans.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!ans.empty()) {
            sb.append(ans.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
