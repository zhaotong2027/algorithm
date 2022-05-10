package Class04;

import java.util.Queue;
import java.util.Stack;

public class Code02_QueueStack {

    public static void main(String[] args) {
        // TODO: 2022/5/10 可以写对数器测试
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        while (stack.size() > 0) {
            System.out.println(stack.peek());
            stack.pop();
        }

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        while (myStack.size > 0) {
            System.out.println(myStack.peek());
            myStack.pop();
        }

       MyQueue myQueue = new MyQueue();
       myQueue.push(1);
       myQueue.push(2);
       while (myQueue.size > 0) {
           System.out.println(myQueue.peek());
           myQueue.pop();
       }

    }

    // 栈，先进后出 FILO O(1)
    public static class MyStack<V> {
        public Node head;
        public int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(int value) {
            Node node = new Node();
            node.value = value;
            if (head == null) {
                head = node;
                size++;
            } else {
                node.next = head; // 把新节点放最前，后进先出，先进后出
                head = node;
//                head.next = node; // 把新节点放head后面，head指向新节点，会丢失head后面原来的节点
//                head = head.next;
                size++;
            }
        }

        public int peek() {
            Node<V> node = new Node<>();
            if (head != null) {
                node = head;
            }
            return node.value;
        }

        public void pop() {
            if (head != null) {
                head = head.next;
                size--;
            }
        }
    }

    // 队列，先进先出 FIFO O(1)
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmoty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // 先进，每次进的都在尾部
        public void push(int value) {
            Node<V> node = new Node<>();
            node.value = value;
            if (tail == null && head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int peek() {
            Node<V> node = new Node<>();
            if (head != null) {
                node = head;
            }
            return node.value;
        }

        public void pop() {
            if (head != null) {
                head = head.next;
                size--;
            } else { // 弹出到最后一个时，head会走到null，但没管tail，tail还指向原来的最后一个，会出现脏数据
                tail = null;
            }
        }
    }

    public static class Node<V> {
        public Node next;
        public int value;

        public int Node(int v) {
            return value;
        }
    }
}
