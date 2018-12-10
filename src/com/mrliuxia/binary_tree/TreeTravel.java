package com.mrliuxia.binary_tree;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class TreeTravel {

    public static void main(String[] args) {
        Node node = Node.getDefaultTree();
        preOrderTravel(node);
        inOrderTravel(node);
        backOrderTravel(node);

        System.out.println("递归");
        preOrderTravel1(node);
        System.out.println();
        inOrderTravel1(node);
        System.out.println();
        backOrderTravel1(node);
        System.out.println();
    }

    public static void preOrderTravel(Node node) {
        System.out.println("Pre Order:");
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                System.out.print(node.value + " ");
                node = node.leftNode;
            } else {
                node = stack.pop();
                node = node.rightNode;
            }
        }
        System.out.println();
    }

    public static void inOrderTravel(Node node) {
        System.out.println("In Order:");
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.rightNode;
            }
        }
        System.out.println();
    }

    public static void backOrderTravel(Node node) {
        System.out.println("Back Order:");
        Stack<Node> stack = new Stack<>();
        Stack<Node> outputStack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                outputStack.push(node);
                stack.push(node);
                node = node.rightNode;
            } else {
                node = stack.pop();
                node = node.leftNode;
            }
        }
        while (outputStack.size() > 0) {
            System.out.print(outputStack.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * 递归
     * @param node
     */
    public static void preOrderTravel1(Node node) {
        System.out.print(node.value+" ");
        if (node.leftNode!=null) {
            preOrderTravel1(node.leftNode);
        }
        if (node.rightNode!=null) {
            preOrderTravel1(node.rightNode);
        }
    }

    public static void inOrderTravel1(Node node) {
        if (node.leftNode!=null) {
            inOrderTravel1(node.leftNode);
        }
        System.out.print(node.value+" ");
        if (node.rightNode!=null) {
            inOrderTravel1(node.rightNode);
        }
    }

    public static void backOrderTravel1(Node node) {
        if (node.leftNode!=null) {
            backOrderTravel1(node.leftNode);
        }
        if (node.rightNode!=null) {
            backOrderTravel1(node.rightNode);
        }
        System.out.print(node.value+" ");
    }

}
