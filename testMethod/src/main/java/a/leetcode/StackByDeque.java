package a.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/implement-stack-using-queues/
 **/
public class StackByDeque {
    Deque<Integer> storage;

    /**
     * Initialize your data structure here.
     */
    public StackByDeque() {
        storage = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        storage.addFirst(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Integer i = storage.pollFirst();
        return i == null ? 0 : i;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Integer i = storage.getFirst();
        return i == null ? 0 : i;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return storage.isEmpty();
    }
}
