package com.mrliuxia.binary_tree;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class MorrisTravel {

    public static void main(String[] args) {
        MorrisTravel.inOrderTravel();
        MorrisTravel.preOrderTravel();
    }

    /**
     * 先序遍历实现
     */
    public static void inOrderTravel() {
        Node currNode = Node.getDefaultTree();
        Node prevNode = null;
        System.out.println("in order travel:");
        while (currNode != null) {
            if (currNode.leftNode == null) {
                System.out.print(currNode.value + " ");
                currNode = currNode.rightNode;
            } else {
                prevNode = currNode.leftNode;
                while (prevNode.rightNode != null && prevNode.rightNode != currNode) {
                    prevNode = prevNode.rightNode;
                }
                if (prevNode.rightNode == null) {
                    prevNode.rightNode = currNode;
                    currNode = currNode.leftNode;
                } else {
                    prevNode.rightNode = null;
                    System.out.print(currNode.value + " ");
                    currNode = currNode.rightNode;
                }
            }
        }
        System.out.println();
    }


    /**
     * 中序遍历实现
     */
    public static void preOrderTravel() {
        Node currNode = Node.getDefaultTree();
        Node prevNode = null;
        System.out.println("pre order travel:");
        while (currNode != null) {
            if (currNode.leftNode == null) {
                System.out.print(currNode.value + " ");
                currNode = currNode.rightNode;
            } else {
                prevNode = currNode.leftNode;
                while (prevNode.rightNode != null && prevNode.rightNode != currNode) {
                    prevNode = prevNode.rightNode;
                }
                if (prevNode.rightNode == null) {
                    System.out.print(currNode.value + " ");
                    prevNode.rightNode = currNode;
                    currNode = currNode.leftNode;
                } else {
                    prevNode.rightNode = null;
                    currNode = currNode.rightNode;
                }
            }
        }
        System.out.println();
    }

    private static class Node {
        private Integer value;
        private Node leftNode;
        private Node rightNode;

        public Node(int value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        /**
         *         1
         *       /   \
         *      2     3
         *    /  \   / \
         *   4   5  6  7
         *  / \  /
         * 8  9 0
         *
         * @return
         */
        private static Node getDefaultTree() {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);
            Node node6 = new Node(6);
            Node node7 = new Node(7);
            Node node8 = new Node(8);
            Node node9 = new Node(9);
            Node node0 = new Node(0);
            node1.leftNode = node2;
            node1.rightNode = node3;
            node2.leftNode = node4;
            node2.rightNode = node5;
            node3.leftNode = node6;
            node3.rightNode = node7;
            node4.leftNode = node8;
            node4.rightNode = node9;
            node5.leftNode = node0;
            System.out.println("default tree:");
            System.out.println("        1\n" +
                    "      /   \\\n" +
                    "     2     3\n" +
                    "   /  \\   / \\\n" +
                    "  4   5  6  7\n" +
                    " / \\  /\n" +
                    "8  9 0");
            return node1;
        }
    }

}
