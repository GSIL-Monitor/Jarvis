package com.mrliuxia.leetcode;

/**
 * Created by Poker on 2017/1/28.
 */
public class _21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode resNode;
        if (l1.val < l2.val) {
            resNode = l1;
            resNode.next = mergeTwoLists(l1.next, l2);
        }else {
            resNode = l2;
            resNode.next = mergeTwoLists(l1, l2.next);
        }
        return resNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
