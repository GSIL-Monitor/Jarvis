package com.mrliuxia.jianzhioffer._06_construct_binary_tree;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/6.
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] prOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        Node rootNode = new ConstructBinaryTree().constructByPreAndIn(prOrder, inOrder);
        System.out.println();
    }

    private Node constructByPreAndIn(int[] preOrder, int[] inOrder) {
        Node rootNode = new Node();
        rootNode.data = preOrder[0];
        int leftLength = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                leftLength = i;
                break;
            }
        }
        if (leftLength != 0) {
            int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, leftLength + 1);
            int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, leftLength);
            rootNode.leftNode = constructByPreAndIn(leftPreOrder, leftInOrder);
        } else {
            rootNode.leftNode = null;
        }
        if (leftLength != inOrder.length - 1) {
            int[] rightPreOrder = Arrays.copyOfRange(preOrder, leftLength + 1, preOrder.length);
            int[] rightInOrder = Arrays.copyOfRange(inOrder, leftLength + 1, inOrder.length);
            rootNode.rightNode = constructByPreAndIn(rightPreOrder, rightInOrder);
        }
        return rootNode;
    }

}

class Node {
    int data;
    Node leftNode;
    Node rightNode;
}
