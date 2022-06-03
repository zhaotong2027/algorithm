package Class04_LinkedList;

//public class LinkedListNode {
//}
public class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode() {
    }

    LinkedListNode(int val) {
        this.val = val;
    }

    LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}
