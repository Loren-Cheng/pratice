package com.pratice.leetcode.stacks_and_queues;

import java.util.Stack;

public class Leetcode_1544_make_the_string_great_03 {
    public static String makeGood(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char currChar : s.toCharArray()
        ) {
            if (!characterStack.isEmpty()
                    && Math.abs(characterStack.lastElement() - currChar) == 32
                //|'a'-'A'|==32
            ) {
                characterStack.pop();
            } else {
                characterStack.push(currChar);
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
