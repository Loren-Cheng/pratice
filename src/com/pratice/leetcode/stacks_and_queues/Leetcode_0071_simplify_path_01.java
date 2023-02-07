package com.pratice.leetcode.stacks_and_queues;

import java.util.Objects;
import java.util.Stack;

public class Leetcode_0071_simplify_path_01 {
    public static String simplifyPath(String path) {
        Stack<String> ansStack = new Stack<>();
        String[] components = path.split("/");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < components.length; i++) {
            if (Objects.equals(components[i], "..")) {
                if (ansStack.size() != 0) {
                    ansStack.pop();
                }
            } else if (Objects.equals(components[i], ".") || Objects.equals(components[i], "")) {
                continue;
            } else {
                ansStack.push(components[i]);
            }
        }

        for (String s : ansStack
        ) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));// "/home"
        System.out.println(simplifyPath("/../"));// "/"
        System.out.println(simplifyPath("/home//foo/"));// "/home/foo"
        System.out.println(simplifyPath("/a/./b/../../c/"));// "/c"
        System.out.println(simplifyPath("/a/../../b/../c//.//"));// "/c"
        System.out.println(simplifyPath("/a//b////c/d//././/.."));//"/a/b/c"
        System.out.println(simplifyPath("/..."));// "/..."
    }
}
