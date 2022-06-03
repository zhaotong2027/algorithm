package Class04_LinkedList;

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

        DoubleLinkedListNode dNode1 = new DoubleLinkedListNode(1);
        DoubleLinkedListNode dNode2 = new DoubleLinkedListNode(2);
        DoubleLinkedListNode dNode3 = new DoubleLinkedListNode(3);
        dNode1.next = dNode2;
        dNode2.next = dNode3;
        dNode3.last = dNode2;
        dNode2.last = dNode1;
        reverseDoubleLinked(dNode1);

        System.out.println("next: ");
        while (dNode3 != null) {
            System.out.print(dNode3.value + " ");
            dNode3 = dNode3.next;
        }
        System.out.println();

        System.out.println("last: ");
        while (dNode1 != null) {
            System.out.print(dNode1.value + " ");
            dNode1 = dNode1.last;
        }
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode head = node;
        LinkedListNode ready = null;
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

    public static DoubleLinkedListNode reverseDoubleLinked(DoubleLinkedListNode dNode) {
        DoubleLinkedListNode head = dNode;
        DoubleLinkedListNode ready = null;
        while (dNode != null) {
            head = dNode.next;
            dNode.next = ready;
            dNode.last = head;
            ready = dNode;
            dNode = head;
        }

        return ready;
    }

}
