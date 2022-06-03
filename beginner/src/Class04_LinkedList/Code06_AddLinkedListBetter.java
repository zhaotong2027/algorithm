package Class04_LinkedList;

public class Code06_AddLinkedListBetter {
    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode(5);
        LinkedListNode list11 = new LinkedListNode(3);
        LinkedListNode list111 = new LinkedListNode(6);
        list1.next = list11;
        list11.next = list111;
        LinkedListNode list2 = new LinkedListNode(5);
        LinkedListNode list22 = new LinkedListNode(9);
        LinkedListNode list222 = new LinkedListNode(9);
        LinkedListNode list2222 = new LinkedListNode(9);
        list2.next = list22;
        list22.next = list222;
        list222.next = list2222;

        LinkedListNode node = addLinkedList(list1, list2);
        printResult(list1, list2, node);
    }

    public static LinkedListNode addLinkedList(LinkedListNode list1, LinkedListNode list2) {
        int len1 = getLinkedLength(list1);
        int len2 = getLinkedLength(list2);
        LinkedListNode longLinked = len1 >= len2 ? list1 : list2;
        LinkedListNode shortLinked = len1 >= len2 ? list2 : list1;
        LinkedListNode last = longLinked;  // 最后补位标识
        int carry = 0;
        int num = 0;

        LinkedListNode returnNode = null;
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
            last.next = new LinkedListNode(1);
        }
        return returnNode;
    }


    public static int getLinkedLength(LinkedListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }


    public static void printResult(LinkedListNode list1, LinkedListNode list2, LinkedListNode node) {
        printLinkedList(list1);
        System.out.print("+");
        printLinkedList(list2);
        System.out.print("=");
        printLinkedList(node);
        System.out.println("");

    }

    public static void printLinkedList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
