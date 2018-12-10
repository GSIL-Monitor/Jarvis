package com.mrliuxia.factory.model;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}
