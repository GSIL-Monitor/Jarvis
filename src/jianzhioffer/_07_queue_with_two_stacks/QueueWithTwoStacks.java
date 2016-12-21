package _07_queue_with_two_stacks;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/8/6.
 */
public class QueueWithTwoStacks {


    private static Stack pushStack = new Stack();
    private static Stack popStack = new Stack();

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.push(1);
        queueWithTwoStacks.push(2);
        queueWithTwoStacks.pop();
        queueWithTwoStacks.push(3);
        queueWithTwoStacks.pop();
        queueWithTwoStacks.pop();
    }

    private void push(Object o) {
        pushStack.push(o);
    }

    private void pop() {
        if (popStack.isEmpty()) {
            if (pushStack.isEmpty()) {
                return;
            }
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        System.out.println(popStack.pop());;
    }

}
