package com.mrliuxia.jianzhioffer.model;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class ListFactory {

    public static Node getList() {
        Node H = new Node("H");
        Node G = new Node("G", H);
        Node F = new Node("F", G);
        Node E = new Node("E", F);
        Node D = new Node("D", E);
        Node C = new Node("C", D);
        Node B = new Node("B", C);
        Node A = new Node("A", B);
        return A;
    }
}
