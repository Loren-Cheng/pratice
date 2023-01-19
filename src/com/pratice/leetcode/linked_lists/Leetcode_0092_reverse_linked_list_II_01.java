package com.pratice.leetcode.linked_lists;

public class Leetcode_0092_reverse_linked_list_II_01 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left <= 0) {
            return head;
        }
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;

        ListNode beforeSwitch = null;
        ListNode leftToEnd = null;
        ListNode rightToBeg = null;
        ListNode afterSwitch = null;

        if (curr.next == null) {
            return head;
        }

        while (curr != null) {
            count++;
            ListNode next;

            if (curr.next != null) {
                next = curr.next;
            } else {
                next = null;
            }

            if (count == left) {
                if (prev != null) {
                    beforeSwitch = prev;
                } else {
                    beforeSwitch = curr;
                }
            }
            if (count == left) {
                leftToEnd = curr;
            }

            if (count == right) {
                rightToBeg = curr;

                if (curr.next != null) {
                    afterSwitch = curr.next;
                } else {
                    afterSwitch = curr;
                }
            }

            if (count >= left && count <= right) {
                if (prev != null) {
                    curr.next = prev;
                } else {
                    prev = curr;
                }
                prev = curr;
            } else {
                prev = curr;
            }
            curr = next;
        }

        if (beforeSwitch != leftToEnd) {
            beforeSwitch.next = rightToBeg;
        } else {
            head = rightToBeg;
        }

        if (rightToBeg != afterSwitch) {
            leftToEnd.next = afterSwitch;
        } else {
            leftToEnd.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};//head = [1,2,3,4,5], left = 2, right = 4   1,4,3,2,5
//        int[] arr = {1};// left = 1, right = 1    1
//        int[] arr = {3, 5};// left = 1 right = 1    3,5
//        int[] arr = {3, 5};// left = 1 right = 2    5,3
//        int[] arr = {1, 2, 3};// left = 1 right = 1    1,2,3
//        int[] arr = {1, 2, 3};// left = 1 right = 2    2,1,3
//        int[] arr = {1, 2, 3};// left = 2 right = 3    1,3,2
//        int[] arr = {1, 2, 3};// left = 1 right = 3    3,2,1
//        int[] arr = {1, 2, 3, 4};// left = 1 right = 3    1,3,2
        int[] arr = {1, 2, 3, 4, 5};//head = [1,2,3,4,5], left = 2, right = 4   1,4,3,2,5

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
        System.out.println("reverseBetween(first, 1, 2) : " + reverseBetween(first, 1, 2));
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
