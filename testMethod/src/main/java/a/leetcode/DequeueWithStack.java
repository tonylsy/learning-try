package a.leetcode;

import java.util.Stack;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/implement-queue-using-stacks/
 **/
public class DequeueWithStack {
    Stack<Integer> storage;
    Stack<Integer> temp;
    /**
     * Initialize your data structure here.
     */
    public DequeueWithStack() {
        storage = new Stack<>();
        temp = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        storage.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        s2t();
        int pop = temp.pop();
        t2s();
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        s2t();
        int peek = temp.peek();
        t2s();
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return storage.isEmpty();
    }

    private void s2t(){
        while(!storage.isEmpty()){
            temp.push(storage.pop());
        }
    }
    private void t2s(){
        while(!temp.isEmpty()){
            storage.push(temp.pop());
        }
    }
}
