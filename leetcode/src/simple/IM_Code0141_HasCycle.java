package simple;

public class IM_Code0141_HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
}

