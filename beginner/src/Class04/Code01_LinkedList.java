package Class04;

/**
 * 跳转结构：单链表值、next指针；双链表值、last指针、next指针
 */
public class Code01_LinkedList {
    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        node1.next = new Node(2);
//        node1.next.next = new Node(3);
//        reverseLinkedList(node1);
//        System.out.println(node1.value);

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node1.next = node2;
//        node2.next = node3;
//        node1 = reverseLinkedList(node1);
//        System.out.println(node1.value);
//
//        while (node1 != null) {
//            System.out.print(node1.value + " ");
//            node1 = node1.next;
//        }

//        DoubleNode doubleNode1 = new DoubleNode(1);
//        doubleNode1.next = new DoubleNode(2);
//        doubleNode1.next.next = new DoubleNode(3);

        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode1.next = doubleNode2;
        doubleNode2.next = doubleNode3;
        doubleNode3.last = doubleNode2;
        doubleNode2.last = doubleNode1;
        reverseDoubleLinked(doubleNode1);

        System.out.println("next: ");
        while (doubleNode3 != null) {
            System.out.print(doubleNode3.value + " ");
            doubleNode3 = doubleNode3.next;
        }
        System.out.println();

        System.out.println("last: ");
        while (doubleNode1 != null) {
            System.out.print(doubleNode1.value + " ");
            doubleNode1 = doubleNode1.last;
        }
    }

    public static Node reverseLinkedList(Node node) {
        Node head = node;
        Node ready = null;
        while (node != null) {
            head = node.next;
            node.next = ready;
            ready = node;
            node = head;
        }
        return ready;

//        Node pre = null;
//        Node next = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
    }

    private static class Node {
        public Node next;
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static DoubleNode reverseDoubleLinked(DoubleNode node) {
        DoubleNode head = node;
        DoubleNode ready = null;
        while (node != null) {
            head = node.next;
            node.next = ready;
            node.last = head;
            ready = node;
            node = head;
        }

        return ready;
    }

    private static class DoubleNode {
        public DoubleNode last;
        public DoubleNode next;
        public int value;

        public DoubleNode(int v) {
            value = v;
        }
    }
}
