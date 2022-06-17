package simple;

public class Code0083_DeleteDuplicates {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(2);
        ListNode list111 = new ListNode(4);
        list1.next = list11;
        list11.next = list12;
        list11.next = list111;

        ListNode head = deleteDuplicates(list1);
        ListNode.printLinkedList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            if (next == null) {
                return head;
            }
            if (cur.val == next.val) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = next;
                next = cur.next;
            }
        }
        return head;
    }
}
