package src.simple;

public class Code0021_MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list111 = new ListNode(4);
        list1.next = list11;
        list11.next = list111;

        ListNode list2 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        ListNode list222 = new ListNode(4);
        list2.next = list22;
        list22.next = list222;

        ListNode node = mergeTwoLists(null, new ListNode());

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode tail = null;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                return head;
            }
            if (list2 == null) {
                tail.next = list1;
                return head;
            }
            if (list1.val <= list2.val) {
                if (head != null) {
                    tail.next = list1;
                    tail = list1;
                    list1 = list1.next;
                } else {
                    head = list1;
                    tail = list1;
                    list1 = list1.next;
                }
            } else {
                if (head != null) {
                    tail.next = list2;
                    tail = list2;
                    list2 = list2.next;
                } else {
                    head = list2;
                    tail = list2;
                    list2 = list2.next;
                }
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
