package com.mrliuxia.bishi.xiaohongshu;

import java.util.Scanner;

/**
 * Created by Poker on 2016/10/30.
 */
public class P3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int startIndex = n/2-(k-1)/2;
        int endIndex = n/2+k/2;
        int index = 1;
        Node root = new Node(scan.nextInt());
        Node preStartNode = root;
        Node backStartNode = null;
        Node midStartNode = null;
        Node midEndNode = null;
        Node curr = root;
        for (int i = 1; i < n; i++) {
            if(index == startIndex) {
                preStartNode = curr;
            }
            Node next = new Node(scan.nextInt());
            curr.next = next;
            curr = next;
            if (index == startIndex) {

            }
            index++;
        }

    }

    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}


