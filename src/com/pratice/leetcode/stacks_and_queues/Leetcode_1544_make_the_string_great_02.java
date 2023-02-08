package com.pratice.leetcode.stacks_and_queues;

import java.util.Stack;

public class Leetcode_1544_make_the_string_great_02 {
    public static String makeGood(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char peek = ' ';
            if (!characterStack.empty()) {
                peek = characterStack.peek();
            }

            if (!characterStack.empty()
                    && Character.toLowerCase(peek) == Character.toLowerCase(s.charAt(i))
                    && peek != s.charAt(i)
            ) {
                characterStack.pop();
            } else {
                characterStack.push(s.charAt(i));
            }

        }
        StringBuilder sb = new StringBuilder();
        int count = characterStack.size();
        for (char c : characterStack
        ) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));//leetcode
        System.out.println(makeGood("abBAcC"));//
        System.out.println(makeGood("s"));//s
    }
}
