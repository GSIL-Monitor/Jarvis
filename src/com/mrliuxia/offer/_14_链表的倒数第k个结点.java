package com.mrliuxia.offer;

/**
 * Created by Poker on 2016/11/3.
 */
public class _14_链表的倒数第k个结点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode pointer = head;
        for (int i = 0; i < k - 1; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
