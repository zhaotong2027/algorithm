package Class04_LinkedList;

/**
 * 目标：用双链表实现从头部或尾部同时能执行的先进先出、后进先出
 * 分析：先进先出用到头尾指针，后进先出只用尾指针
 * 可以先简化成，根据头尾标识，把节点添加到头尾部，根据头尾标识，把元素从头尾部删除。
 */
public class Code03_DoubleLinkedListQueueStack {

    public static final String queue = "queue";
    public static final String stack = "stack";
    public static final String headS = "head";
    public static final String tailS = "tail";

    public static void main(String[] args) {

        DoubleLinkedListQueueStack myDLL = new DoubleLinkedListQueueStack();
        System.out.println("测试一：头部队列 1/2 进123，出123");
        myDLL.pushQueueHead(1);
        myDLL.pushQueueHead(2);
        myDLL.pushQueueHead(3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.peekHead());
            myDLL.popHead();
        }
        System.out.println("测试一：头部队列 2/2 进123，出123");
        myDLL.doPush(queue, headS, 1);
        myDLL.doPush(queue, headS, 2);
        myDLL.doPush(queue, headS, 3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.doPeek(headS));
            myDLL.doPop(headS);
        }

        System.out.println("测试二：尾部队列 1/2 进123，出123");
        myDLL.pushQueueTail(1);
        myDLL.pushQueueTail(2);
        myDLL.pushQueueTail(3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.peekTail());
            myDLL.popTail();
        }
        System.out.println("测试二：尾部队列 2/2 进123，出123");
        myDLL.doPush(queue, tailS, 1);
        myDLL.doPush(queue, tailS, 2);
        myDLL.doPush(queue, tailS, 3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.doPeek(tailS));
            myDLL.doPop(tailS);
        }

        System.out.println("测试三：头部栈 1/2 进123，出321");
        myDLL.pushStackHead(1);
        myDLL.pushStackHead(2);
        myDLL.pushStackHead(3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.peekHead());
            myDLL.popHead();
        }
        System.out.println("测试三：头部栈 2/2 进123，出321");
        myDLL.doPush(stack, headS, 1);
        myDLL.doPush(stack, headS, 2);
        myDLL.doPush(stack, headS, 3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.doPeek(headS));
            myDLL.doPop(headS);
        }

        System.out.println("测试四：尾部栈 1/2 进123，出321");
        myDLL.pushStackTail(1);
        myDLL.pushStackTail(2);
        myDLL.pushStackTail(3);
        while (myDLL.size > 0) {
            int i = myDLL.peekTail();
            System.out.println(myDLL.peekTail());
            myDLL.popTail();
        }
        System.out.println("测试四：尾部栈 2/2 进123，出321");
        myDLL.doPush(stack, tailS, 1);
        myDLL.doPush(stack, tailS, 2);
        myDLL.doPush(stack, tailS, 3);
        while (myDLL.size > 0) {
            System.out.println(myDLL.doPeek(tailS));
            myDLL.doPop(tailS);
        }
    }

    public static class DoubleLinkedListQueueStack<V> {
        public DoubleNode head;
        public DoubleNode tail;
        public int size;

        public DoubleLinkedListQueueStack() {
            head = null;
            tail = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

//        public void dos(int value) {
//            // queue head push
//            // stack tail push
//            pushHead(value);
//
//            // queue tail push
//            // stack head push
//            pushTail(value);
//
//            // queue head pop
//            // stack head pop
//            popHead();
//
//            // queue tail pop
//            // stack tail pop
//            popTail();
//        }

        public void doPush(String isQS, String isHT, int value) {
            if (queue.equals(isQS) && headS.equals(isHT)) {
                pushQueueHead(value);
            }
            if (stack.equals(isQS) && tailS.equals(isHT)) {
                pushStackTail(value);
            }
            if (queue.equals(isQS) && tailS.equals(isHT)) {
                pushQueueTail(value);
            }
            if (stack.equals(isQS) && headS.equals(isHT)) {
                pushStackHead(value);
            }
        }

        public void doPop(String isHT) {
            if (isHT.equals(headS)) {
                popHead();
            } else {
                popTail();
            }
        }

        public int doPeek(String isHT) {
//            if (isHT.equals(headS) && head != null) {
//                return head.value;
//            } else if (isHT.equals(tailS) && tail != null){
//                return tail.value;
//            } else {
//                return Integer.MIN_VALUE;
//            }
            if (headS.equals(isHT)) {
                return peekHead();
            }
            if (tailS.equals(isHT)) {
                return peekTail();
            }
            return Integer.MIN_VALUE;
        }

        private void pushStackTail(int value) {
            DoubleNode doubleNode = new DoubleNode(value);
            if (tail == null) {
                tail = doubleNode;
                head = doubleNode;
                size++;
            } else {
                tail.next = doubleNode;
                doubleNode.last = tail;
                tail = doubleNode;
                size++;
            }
        }

        // 尾部添加新节点，尾指针不变，头指针last指向新节点，头节点变为新节点
        private void pushQueueTail(int value) {
            DoubleNode doubleNode = new DoubleNode(value);
            if (tail == null) {
                tail = doubleNode;
                head = doubleNode;
                size++;
            } else {
                head.last = doubleNode;
                doubleNode.next = head;
                head = doubleNode;
                size++;
            }
        }

        private void pushStackHead(int value) {
            DoubleNode doubleNode = new DoubleNode(value);
            if (tail == null) {
                tail = doubleNode;
                head = doubleNode;
                size++;
            } else {
                doubleNode.next = head;
                head.last = doubleNode;
                head = doubleNode;
                size++;
            }
        }

        // 头部添加新节点，头指针不变，尾指针next指向新节点，尾节点变为新节点
        private void pushQueueHead(int value) {
            DoubleNode doubleNode = new DoubleNode(value);
            if (head == null) {
                head = doubleNode;
                tail = doubleNode;
                size++;
            } else {
                tail.next = doubleNode;
                doubleNode.last = tail;
                tail = doubleNode;
                size++;
            }
        }

        // 尾部节点出去，尾指针前移
        private void popTail() {
            if (tail != null) {
                tail = tail.last;
                size--;
            } else {
                head = null;
            }
            if (size == 0) {
                head = null;
                tail = null;
            }
        }

        // 头部节点出去，头指针后移
        private void popHead() {
            if (head != null) {
                head = head.next;
                size--;
            } else {
                tail = null;
            }
            if (size == 0) {
                head = null;
                tail = null;
            }
        }

        private int peekTail() {
            if (tail != null) {
                return tail.value;
            }
            return Integer.MIN_VALUE;
        }

        private int peekHead() {
            if (head != null) {
                return head.value;
            }
            return Integer.MAX_VALUE;
        }
    }

    public static class DoubleNode<V> {
        public DoubleNode last;
        public DoubleNode next;
        public int value;

        public DoubleNode(int v) {
            value = v;
        }
    }
}
