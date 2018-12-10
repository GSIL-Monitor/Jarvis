package com.mrliuxia.exercise._0916_;

import com.mrliuxia.factory.TreeFactory;
import com.mrliuxia.factory.model.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class TreeTravel {

    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeFactory.getBinaryTree();
        preOrder_loop(rootNode);
        inOrder_loop(rootNode);
        backOrder(rootNode);
        preOrder_morris(rootNode);
        inOrder_morris(rootNode);
    }

    private static void preOrder_loop(BinaryTreeNode rootNode) {
        System.out.print("pre order:");
        if (rootNode == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeNode node = rootNode;
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

    private static void inOrder_loop(BinaryTreeNode rootNode) {
        System.out.print("in  order:");
        if (rootNode == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeNode node = rootNode;
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

    private static void backOrder(BinaryTreeNode rootNode) {
        System.out.print("bck order:");
        if (rootNode == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeNode node = rootNode;
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

    private static void preOrder_morris(BinaryTreeNode rootNode) {
        System.out.print("pre order_morris:");
        if (rootNode == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeNode currentNode = rootNode;
        BinaryTreeNode previousNode = null;
        while (currentNode != null) {
            if (currentNode.leftNode == null) {
                System.out.print(currentNode.value);
                currentNode = currentNode.rightNode;
            } else {
                previousNode = currentNode.leftNode;
                while (previousNode.rightNode != null && previousNode.rightNode != currentNode) {
                    previousNode = previousNode.rightNode;
                }
                if (previousNode.rightNode == null) {
                    System.out.print(currentNode.value);
                    previousNode.rightNode = currentNode;
                    currentNode = currentNode.leftNode;
                }
                if (previousNode.rightNode == currentNode) {
                    previousNode.rightNode = null;
                    currentNode = currentNode.rightNode;
                }
            }
        }
        System.out.println();
    }

    private static void inOrder_morris(BinaryTreeNode rootNode) {
        System.out.print("in  order_morris:");
        if (rootNode == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeNode currentNode = rootNode;
        BinaryTreeNode previousNode = null;
        while (currentNode != null) {
            if (currentNode.leftNode == null) {
                System.out.print(currentNode.value);
                currentNode = currentNode.rightNode;
            } else {
                previousNode =currentNode.leftNode;
                while (previousNode.rightNode!=null&&previousNode.rightNode!=currentNode) {
                    previousNode = previousNode.rightNode;
                }
                if (previousNode.rightNode == null) {
                    previousNode.rightNode = currentNode;
                    currentNode = currentNode.leftNode;
                }
                if (previousNode.rightNode == currentNode) {
                    previousNode.rightNode = null;
                    System.out.print(currentNode.value);
                    currentNode = currentNode.rightNode;
                }
            }
        }
        System.out.println();
    }

}
