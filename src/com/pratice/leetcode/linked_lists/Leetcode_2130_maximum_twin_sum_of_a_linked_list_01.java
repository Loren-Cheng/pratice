package com.pratice.leetcode.linked_lists;

public class Leetcode_2130_maximum_twin_sum_of_a_linked_list_01 {
    public static int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode end = null;

        while (curr != null) {
            slow = curr.next;

            if (fast != null) {
                end = fast;
                if (null == fast.next.next) {
                    while (end.next != null) {
                        end = end.next;
                    }
                }
                fast = fast.next.next;
            } else {
                if (prev != null && curr.next != null) {
                    curr.next = prev;
                } else {
                    curr.next = prev;
                    end = curr;
                }
                prev = curr;
            }
            curr = slow;
        }

        while (head != null && end != null) {
            max = Math.max(max, head.val + end.val);
            head = head.next;
            end = end.next;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1};//6
//        int[] arr = {1,100000};//100001
        ListNode tmp = null;
        //LinkedList第一筆node
        ListNode first = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode link = new ListNode(arr[i], null);
            if (tmp != null) {
                //tmp為前一筆node
                tmp.setNext(link);
            } else {
                first = link;
            }
            tmp = link;
        }
        System.out.println(first);
        System.out.println(pairSum(first));

    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return val + ", " + next;
        }
    }
}
