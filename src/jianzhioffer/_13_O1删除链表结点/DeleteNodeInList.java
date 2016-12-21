package jianzhioffer._13_O1删除链表结点;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class DeleteNodeInList {

    public static void main(String[] args) {
        Node node5 = new Node("5");
        Node node4 = new Node("4", node5);
        Node node3 = new Node("3", node4);
        Node node2 = new Node("2", node3);
        Node node1 = new Node("1", node2);
        Node root = new Node("0", node1);

        printList(root);
        deleteNode(root, node3);
        printList(root);
        deleteNode(root, node5);
        printList(root);
        deleteNode(root, node1);
        printList(root);
    }

    private static void deleteNode(Node rootNode, Node toDeleteNode) {
        if (rootNode == null || toDeleteNode == null) {
            return;
        }
        if (toDeleteNode.nextNode != null) {
            Node tempNode = toDeleteNode.nextNode;
            toDeleteNode.value = tempNode.value;
            toDeleteNode.nextNode = tempNode.nextNode;
        } else if (toDeleteNode == rootNode) {
            rootNode = null;
        } else {
            Node currentNode = rootNode;
            while (currentNode.nextNode != toDeleteNode) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = null;
        }
        System.out.println();
    }

    private static void printList(Node rootNode) {
        Node currentNode = rootNode;
        while (currentNode!=null) {
            System.out.print(currentNode.value+" ");
            currentNode = currentNode.nextNode;
        }
    }

    private static class Node {
        private String value;
        private Node nextNode;

        private Node(String value) {
            this.value = value;
            this.nextNode = null;
        }

        private Node(String value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }
}
