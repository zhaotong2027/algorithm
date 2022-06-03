package Class04_LinkedList;

public class Code04_ReverseKGroupLinkedList {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 3;

        LinkedListNode node = reverseKGroup(node1, k);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        LinkedListNode start = head;
        LinkedListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组
        head = end;
        reverse(start, end);
        // 上组的尾节点
        LinkedListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static void reverse(LinkedListNode start, LinkedListNode end) {
        end = end.next;
        LinkedListNode pre = null;
        LinkedListNode cur = start;
        LinkedListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static LinkedListNode getKGroupEnd(LinkedListNode start, int k) {
        if (start.next == null) {
            return start;
        }
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

}
