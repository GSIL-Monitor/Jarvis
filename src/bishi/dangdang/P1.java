package bishi.dangdang;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pokerface_lx
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node root = new Node(scan.nextLine());
        Node currNode = root;
        int lastBlankNum = 0;
        while (scan.hasNext()) {
            String str = scan.nextLine();
            int blankNum = str.lastIndexOf(" ")+1 ;
            str = str.substring(blankNum);
            if (blankNum == lastBlankNum) {
                Node node = new Node(currNode.father, str);
                currNode.father.childs.add(node);
                currNode = node;
                lastBlankNum = blankNum;
                continue;
            }
            if (blankNum < lastBlankNum) {
                Node node = new Node(currNode.father.father, str);
                currNode.father.father.childs.add(node);
                currNode = node;
                lastBlankNum = blankNum;
                continue;
            }
            if (blankNum > lastBlankNum) {
                Node node = new Node(currNode, str);
                currNode.childs.add(node);
                currNode = node;
                lastBlankNum = blankNum;
                continue;
            }
        }
        System.out.println();
    }


    private static class Node {
        String val;
        List<Node> childs;
        Node father;

        Node(String val) {
            this.val = val;
            this.father = null;
            this.childs = new LinkedList<>();
        }

        Node(Node father, String val) {
            this.father = father;
            this.val = val;
            this.childs = new LinkedList<>();
        }
    }
}
