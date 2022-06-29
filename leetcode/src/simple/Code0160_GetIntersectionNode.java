package simple;

public class Code0160_GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        ListNode headIn = new ListNode(8);
        headA.next.next = headIn;
        headB.next.next.next = headIn;
        headIn.next = new ListNode(4);
        headIn.next.next = new ListNode(5);

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headNB = headB;
        while (headA != null) {
            while (headNB != null) {
                if (headA == headNB) {
                    return headA;
                }
                headNB = headNB.next;
            }
            headA = headA.next;
            headNB = headB;
        }
        return null;
    }
}
