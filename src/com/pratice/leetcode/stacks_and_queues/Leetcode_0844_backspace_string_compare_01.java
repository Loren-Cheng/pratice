package com.pratice.leetcode.stacks_and_queues;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode_0844_backspace_string_compare_01 {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()
        ) {
            if (c == '#') {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        for (char c : t.toCharArray()
        ) {
            if (c == '#') {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }
        //return String.valueOf(stack1).equals(String.valueOf(stack1));
        return Arrays.toString(stack1.toArray()).contentEquals(Arrays.toString(stack2.toArray()));
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }
}
