package com.mrliuxia.jianzhioffer._15_链表中倒数第k个结点;

import com.mrliuxia.jianzhioffer.model.ListFactory;
import com.mrliuxia.jianzhioffer.model.Node;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class KthNodeFromEnd {

    public static void main(String[] args) {
        Node rootNode = ListFactory.getList();
        printList(rootNode);
        System.out.println(getKthFromEnd(rootNode, 5));
    }

    private static Node getKthFromEnd(Node rootNode, int k) {
        if (k < 1 || rootNode == null) {
            return null;
        }
        Node frontNode = rootNode;
        for (int i = 0; i < k; i++) {
            if (frontNode.nextNode == null) {
                return null;
            } else {
                frontNode = frontNode.nextNode;
            }
        }
        Node backNode = rootNode;
        while (frontNode!=null) {
            backNode = backNode.nextNode;
            frontNode = frontNode.nextNode;
        }
        return backNode;
    }

    private static void printList(Node rootNode) {
        while (rootNode!=null) {
            System.out.print(rootNode);
            rootNode = rootNode.nextNode;
        }
        System.out.println();
    }

}
