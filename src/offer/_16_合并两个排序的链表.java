package offer;

import sun.tools.tree.PreIncExpression;

/**
 * Created by Poker on 2016/11/3.
 */
public class _16_合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode merge = new _16_合并两个排序的链表().merge(list1, list2);
        System.out.println();
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode root = new ListNode(0);
        ListNode pointer = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        if (list1 != null) {
            pointer.next = list1;
        }
        if (list2 != null) {
            pointer.next = list2;
        }
        return root.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
