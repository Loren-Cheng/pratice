package com.pratice.leetcode.linked_lists;

public class Leetcode_0024_swap_nodesin_pairs_01 {
    public static ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode ans = new ListNode(-1);

        if (curr != null && curr.next == null) {
            return head;
        }

        while (curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = curr.next;

            if (prev != null) {
                prev.next = second;
            }

            if (second.next != null) {
                first.next = second.next;
                second.next = first;
            } else {
                first.next = null;
                second.next = first;
            }

            prev = first;

            if (ans.next == null) {
                ans.next = second;
            }

            curr = first.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};//2,1,4,3
        int[] arr = {2, 5, 3, 4, 6, 2, 2};//5,2,4,3,2,6,2
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
        System.out.println(swapPairs(first));
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
            return val + ",  " + next;
        }
    }

}
