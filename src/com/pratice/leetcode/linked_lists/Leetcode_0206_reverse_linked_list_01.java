package com.pratice.leetcode.linked_lists;

public class Leetcode_0206_reverse_linked_list_01 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
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
        System.out.println(reverseList(first));
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
            return val + ", " + next ;
        }
    }

}
