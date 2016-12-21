package jianzhioffer._16_反转链表;

import jianzhioffer.model.ListFactory;
import jianzhioffer.model.Node;

/**
 * Created by pokerface_lx on 16/9/13.
 */
public class ReverseList {

    public static void main(String[] args) {
        Node ori = ListFactory.getList();
        print(ori);
        Node rev = reverseList(ori);
        print(rev);
    }

    private static Node reverseList(Node headNode) {
        Node reverseHeadNode = null;
        Node currentNode = headNode;
        Node previousNode = null;
        Node nextNode = null;
        while (currentNode != null) {
            reverseHeadNode = currentNode;
            nextNode = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return reverseHeadNode;
    }

    private static void print(Node rootNode) {
        if (rootNode==null) {
            return;
        }
        while (rootNode!=null) {
            System.out.print(rootNode);
            rootNode = rootNode.nextNode;
        }
        System.out.println();
    }
}
