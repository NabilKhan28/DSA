
package com.gs.dsa.ds;

import java.util.Stack;

/**
 * Implement a FIFO queue using two stacks.
 * Edge cases: empty queue ops, multiple consecutive peeks/pops, large sequences.
 */
public final class QueueUsingStacks {
    private QueueUsingStacks() {}
    public static final class MyQueue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();
        /** TODO: Push to input stack. */
        public void push(int x) {
            input.push(x);
            /* no-op */
        }
        /** TODO: Move elements to output stack and pop. */
        public int pop() {
            shiftStalks();
            if(output.isEmpty()){
                throw new IllegalStateException("Queue is empty");
            }
            return output.pop();
        }

        private void shiftStalks() {
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
        }

        /** TODO: Peek element at front. */
        public int peek() {
            shiftStalks();
            if(output.isEmpty()){
                throw new IllegalStateException("Queue is empty");
            }
            return output.peek();
        }
        /** TODO: Return true if both stacks empty. */
        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop());  // 1
        System.out.println(queue.peek()); // 2
        queue.push(4);
        System.out.println(queue.pop());  // 2
        System.out.println(queue.pop());  // 3
        System.out.println(queue.pop());  // 4
        System.out.println(queue.empty()); // true
    }
}
