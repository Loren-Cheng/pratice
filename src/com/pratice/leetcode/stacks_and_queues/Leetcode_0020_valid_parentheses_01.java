package com.pratice.leetcode.stacks_and_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode_0020_valid_parentheses_01 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matching = new HashMap<>();
        matching.put('(', ')');
        matching.put('{', '}');
        matching.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (matching.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (matching.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
        System.out.println(isValid("(){}}{"));
    }
}
