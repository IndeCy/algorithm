package 用队列实现栈225;

import java.util.LinkedList;

public class MyStack {

    LinkedList<Integer> stack;
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return stack.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
