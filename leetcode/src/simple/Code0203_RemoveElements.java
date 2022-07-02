package simple;

public class Code0203_RemoveElements {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        removeElements(headA, 4);
        ListNode.printLinkedList(headA);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode root = head;
        ListNode pre = head;
        ListNode cur = head;
        ListNode next = head;
        if (head != null) {
            next = head.next;
        } else {
            next = null;
        }
        while (cur != null) {
            System.out.println(cur.val);
            if (root.val == val) {
                root = null;
            }
            if (cur.val != val) {
                pre = cur;
                cur = next;
                if (next != null) {
                    next = cur.next;
                } else {
                    next = null;
                }
            } else {
                pre.next = next;
                cur = pre.next;
                if (next != null) {
                    next = cur.next;
                } else {
                    next = null;
                }
            }
            if (root == null) {
                root = cur;
            }
        }
        return root;
    }
}
