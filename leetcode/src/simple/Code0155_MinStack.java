package simple;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 也可以用node的方式写个栈
 */
public class Code0155_MinStack {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());   // 返回 -2.

    }

    public static class MinStack {
        LinkedList<Integer> myStack = new LinkedList();

        public MinStack() {
//            this.myStack = myStack;
        }

        public void push(int val) {
            myStack.push(val);
        }

        public void pop() {
            myStack.pop();
        }

        public int top() {
            return myStack.getFirst();
        }

        public int getMin() {
            LinkedList<Integer> sortStack = new LinkedList<>(myStack);
            Collections.sort(sortStack);
            return sortStack.getFirst();
        }
    }
}
