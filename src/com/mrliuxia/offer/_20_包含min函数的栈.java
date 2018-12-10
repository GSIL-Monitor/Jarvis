package com.mrliuxia.offer;

import java.util.Stack;

/**
 * Created by Poker on 2016/11/3.
 */
public class _20_包含min函数的栈 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.size() == 0 || node <= minStack.peek()) {
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
