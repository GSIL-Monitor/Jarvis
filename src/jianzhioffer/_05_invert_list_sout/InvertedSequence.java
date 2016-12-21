package _05_invert_list_sout;

import model.ListNode;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class InvertedSequence {

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(0);
        // 初始化 此处省略
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = rootNode;
        while (currentNode.getNextNode() != null) {
            stack.add(currentNode.getKey());
            currentNode = currentNode.getNextNode();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
