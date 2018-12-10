package com.mrliuxia.offer;

/**
 * Created by Poker on 2016/11/3.
 */
public class _15_反转链表 {

    public ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            reverseHead = curr;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return reverseHead;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
