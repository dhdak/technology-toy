package com.weizihe.algorithm;

/**
 * @author weizihe
 * @date 2021-05-18 16:01
 */
public class SwapPairs {

    //     Definition for singly-linked list.
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
        @Override
        public String toString() {
            return ""+val;
        }
    }


    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode listNode = swapPairs.swapPairs(head);
        System.out.println(listNode);

    }

    public ListNode swapPairs(ListNode head) {

        ListNode tmpHead = new ListNode();
        tmpHead.next = head;

        ListNode listNode = realSwapPairs(tmpHead);
        return listNode;

    }

    public ListNode realSwapPairs(ListNode preHead) {

        if (preHead.next == null || preHead.next.next == null) {
            return preHead;
        }

        ListNode head = preHead.next;
//        ListNode end = preHead.next.next;
        ListNode thire = preHead.next.next.next;
        preHead.next = preHead.next.next;
        preHead.next.next = head;
        preHead.next.next.next = thire;
        return realSwapPairs(preHead.next.next);

    }
}
