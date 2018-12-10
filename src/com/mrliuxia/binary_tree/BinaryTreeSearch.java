package com.mrliuxia.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by apple on 16/6/18.
 */
public class BinaryTreeSearch {

    public static void BFS(BinaryTree tree) {
        Queue<BinaryTreeNode> openQueue = new LinkedList<>();
        Queue<BinaryTreeNode> closeQueue = new LinkedList<>();
        openQueue.add(tree.getRoot());
        while (openQueue.size() > 0) {
            if (openQueue.peek().getLeftNode() != null) {
                openQueue.add(openQueue.peek().getLeftNode());
            }
            if (openQueue.peek().getRightNode() != null) {
                openQueue.add(openQueue.peek().getRightNode());
            }
            System.out.print(openQueue.peek().getRoot());
            closeQueue.add(openQueue.poll());
        }
        System.out.println();
    }

    public static void DFS (BinaryTree tree) {
        Stack<BinaryTreeNode> openStack = new Stack<>();
        Stack<BinaryTreeNode> closeStack = new Stack<>();
        openStack.add(tree.getRoot());
        while (openStack.size() > 0) {
            closeStack.add(openStack.pop());
            System.out.print(closeStack.peek().getRoot());
            if (closeStack.peek().getRightNode() != null) {
                openStack.add(closeStack.peek().getRightNode());
            }
            if (closeStack.peek().getLeftNode() != null) {
                openStack.add(closeStack.peek().getLeftNode());
            }
        }
        System.out.println();
    }

}
