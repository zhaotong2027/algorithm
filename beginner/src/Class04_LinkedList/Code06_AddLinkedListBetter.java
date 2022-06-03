package Class04_LinkedList;

public class Code06_AddLinkedListBetter {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode list11 = new ListNode(3);
        ListNode list111 = new ListNode(6);
        list1.next = list11;
        list11.next = list111;
        ListNode list2 = new ListNode(5);
        ListNode list22 = new ListNode(9);
        ListNode list222 = new ListNode(9);
        ListNode list2222 = new ListNode(9);
        list2.next = list22;
        list22.next = list222;
        list222.next = list2222;

        ListNode node = addLinkedList(list1, list2);
        printResult(list1, list2, node);
    }

    public static ListNode addLinkedList(ListNode list1, ListNode list2) {
        int len1 = getLinkedLength(list1);
        int len2 = getLinkedLength(list2);
        ListNode longLinked = len1 >= len2 ? list1 : list2;
        ListNode shortLinked = len1 >= len2 ? list2 : list1;
        ListNode last = longLinked;  // 最后补位标识
        int carry = 0;
        int num = 0;

        ListNode returnNode = null;
        while (shortLinked != null) {
            num = longLinked.val + shortLinked.val + carry;
            carry = num / 10;
            longLinked.val = num % 10;
            if (returnNode == null) {
                returnNode = longLinked;
            }
            last = longLinked;
            longLinked = longLinked.next;
            shortLinked = shortLinked.next;
        }
        while (longLinked != null) {
            num = longLinked.val + carry;
            carry = num / 10;
            longLinked.val = num % 10;
            last = longLinked;
            longLinked = longLinked.next;
        }
        if (carry == 1) {
            last.next = new ListNode(1);
        }
        return returnNode;
    }


    public static int getLinkedLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }


    public static void printResult(ListNode list1, ListNode list2, ListNode node) {
        printLinkedList(list1);
        System.out.print("+");
        printLinkedList(list2);
        System.out.print("=");
        printLinkedList(node);
        System.out.println("");

    }

    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
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
