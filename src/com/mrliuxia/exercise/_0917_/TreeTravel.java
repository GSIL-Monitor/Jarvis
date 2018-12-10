package com.mrliuxia.exercise._0917_;

import com.mrliuxia.factory.TreeFactory;
import com.mrliuxia.factory.model.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/17.
 */
public class TreeTravel {

    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeFactory.getBinaryTree();
        pre_order_loop(rootNode);
        in_order_loop(rootNode);
        back_order_loop(rootNode);
        pre_order_morris(rootNode);
        in_order_morris(rootNode);
    }

    private static void pre_order_loop(BinaryTreeNode node) {
        System.out.print("pre_order_loop:");
        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                System.out.print(node.value);
                node = node.leftNode;
            } else {
                node = stack.pop();
                node = node.rightNode;
            }
        }
        System.out.println();
    }

    private static void in_order_loop(BinaryTreeNode node) {
        System.out.print("in_order_loop:");
        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                node = stack.pop();
                System.out.print(node.value);
                node = node.rightNode;
            }
        }
        System.out.println();
    }

    private static void back_order_loop(BinaryTreeNode node) {
        System.out.print("back_order_loop:");
        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> outStack = new Stack<>();
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                outStack.push(node);
                node = node.rightNode;
            } else {
                node = stack.pop();
                node = node.leftNode;
            }
        }
        while (outStack.size() > 0) {
            System.out.print(outStack.pop().value);
        }
        System.out.println();
    }

    private static void pre_order_morris(BinaryTreeNode node) {
        System.out.print("pre_order_morris:");
        if (node == null) {
            return;
        }
        BinaryTreeNode currNode = node;
        BinaryTreeNode prevNode = null;
        while (currNode != null) {
            if (currNode.leftNode == null) {
                System.out.print(currNode.value);
                currNode = currNode.rightNode;
            } else {
                prevNode = currNode.leftNode;
                while (prevNode.rightNode != null && prevNode.rightNode != currNode) {
                    prevNode = prevNode.rightNode;
                }
                if (prevNode.rightNode == null) {
                    System.out.print(currNode.value);
                    prevNode.rightNode = currNode;
                    currNode = currNode.leftNode;
                }
                if (prevNode.rightNode == currNode) {
                    prevNode.rightNode = null;
                    currNode = currNode.rightNode;
                }
            }
        }
        System.out.println();
    }

    private static void in_order_morris(BinaryTreeNode node) {
        System.out.print("in_order_morris:");
        if (node == null) {
            return;
        }
        BinaryTreeNode currNode = node;
        BinaryTreeNode prevNode = null;
        while (currNode != null) {
            if (currNode.leftNode == null) {
                System.out.print(currNode.value);
                currNode = currNode.rightNode;
            } else {
                prevNode = currNode.leftNode;
                while (prevNode.rightNode != null && prevNode.rightNode != currNode) {
                    prevNode = prevNode.rightNode;
                }
                if (prevNode.rightNode == null) {
                    prevNode.rightNode = currNode;
                    currNode = currNode.leftNode;
                }
                if (prevNode.rightNode == currNode) {
                    System.out.print(currNode.value);
                    prevNode.rightNode = null;
                    currNode = currNode.rightNode;
                }
            }
        }
        System.out.println();
    }
}
