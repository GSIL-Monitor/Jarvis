package com.mrliuxia.jianzhioffer.model;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class Node {
    public String value;
    public Node nextNode;

    public Node() {
        this.value = null;
        this.nextNode = null;
    }

    public Node(String value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(String value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return value+" ";
    }
}