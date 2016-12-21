package bishi.wanmeishijie;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/19.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            List<Integer> list = new LinkedList<>();
            try {
                int n = scan.nextInt();
                for (int i = 0; i < n; i++) {
                    list.add(scan.nextInt());
                }
            } catch (Exception e) {
                System.out.println("error");
            }
            int index = 0, value = 0;
            try {
                index = scan.nextInt();
                value = scan.nextInt();
                if (index > list.size()) {
                    System.out.println("error");
                } else {
                    list.add(index, value);
                }
            } catch (Exception e) {
                System.out.println("error");
            }
            try {
                index = scan.nextInt();
                if (index >= list.size()) {
                    System.out.println("errot");
                } else {
                    list.remove(index);
                }
            } catch (Exception e) {
                System.out.println("error");
            }
            for (Integer i : list) {
                if (list.indexOf(i) != list.size() - 1) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i);
                }
            }
        }
    }
    public static class MyLinkedList<E>{
        int size = 0;
        Node<E> first;
        Node<E> last;
        void add(E e) {
            Node<E> l = last;
            Node<E> newNode = new Node<E>(l,e,null);
            last = newNode;
            if (l == null) {
                first = newNode;
            }else {
                l.next = newNode;
            }
            size++;
        }

    }
    private static class Node<E>{
        E value;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E value, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
