package com.pratice.leetcode.stacks_and_queues;

import java.util.Stack;

public class Leetcode_1544_make_the_string_great_01 {
    public static String makeGood(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char peek = ' ';
            if (!characterStack.empty()) {
                peek = characterStack.peek();
            }

            characterStack.push(s.charAt(i));


            if (!characterStack.empty()
                    && Character.toLowerCase(peek) == Character.toLowerCase(s.charAt(i))
                    && peek != s.charAt(i)
            ) {
                characterStack.pop();
                characterStack.pop();
            }

        }
        StringBuilder sb = new StringBuilder();
        int count = characterStack.size();
        for (int i = 0; i < count; i++) {
            sb.append(characterStack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));//leetcode
        System.out.println(makeGood("abBAcC"));//
        System.out.println(makeGood("s"));//s
    }
}
