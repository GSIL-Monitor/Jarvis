package com.mrliuxia.binary_tree;

/**
 * Created by apple on 16/6/18.
 * 生成默认的二叉树,初始化
 */
public class BinaryTree {

    private BinaryTreeNode root;

    /**
     *          A
     *        /  \
     *       B    C
     *     /  \  / \
     *    D   E F  G
     *       / / \
     *      H I  J
     */
    public BinaryTree() {
        BinaryTreeNode node3_0 = new BinaryTreeNode("H");
        BinaryTreeNode node3_1 = new BinaryTreeNode("I");
        BinaryTreeNode node3_2 = new BinaryTreeNode("J");

        BinaryTreeNode node2_0 = new BinaryTreeNode("D");
        BinaryTreeNode node2_1 = new BinaryTreeNode(node3_0, null, "E");
        BinaryTreeNode node2_2 = new BinaryTreeNode(node3_1, node3_2, "F");
        BinaryTreeNode node2_3 = new BinaryTreeNode("G");

        BinaryTreeNode node1_0 = new BinaryTreeNode(node2_0, node2_1, "B");
        BinaryTreeNode node1_1 = new BinaryTreeNode(node2_2, node2_3, "C");

        root = new BinaryTreeNode(node1_0, node1_1, "A");
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
}
