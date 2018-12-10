package com.mrliuxia.factory;

import com.mrliuxia.factory.model.BinaryTreeNode;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class TreeFactory {

    /**
     *                  1
     *             /        \
     *            2         3
     *         /    \     /    \
     *        4     5    6      7
     *      /  \
     *     8    9
     *
     *
     * @return
     */
    public static BinaryTreeNode getBinaryTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;
        node4.leftNode = node8;
        node4.rightNode = node9;
        return node1;
    }


}
