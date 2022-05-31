package Class04;

public class Code05_AddLinkedList {
    public static void main(String[] args) {
        ListNode list1 = null;
//        ListNode list11 = new ListNode(3);
//        ListNode list111 = new ListNode(6);
//        list1.next = list11;
//        list11.next = list111;
        ListNode list2 = new ListNode(0);
//        ListNode list22 = new ListNode(9);
//        ListNode list222 = new ListNode(9);
//        ListNode list2222 = new ListNode(9);
//        list2.next = list22;
//        list22.next = list222;
//        list222.next = list2222;

        ListNode node = addLinkedList(list1, list2);
        printResult(list1, list2, node);
    }

    public static ListNode addLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode node = new ListNode();

        // 个位数运算
        int num = list1.val + list2.val;
        node.val = num % 10;
        if (num < 10 && (list1.next == null && list2.next == null)) {
            return node;
        }
        ListNode reusltNode = node;
        node.next = new ListNode(num / 10);
        node = node.next;
        list1 = list1.next;
        list2 = list2.next;

        // 十位及以上
        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                num = list2.val + node.val;
                node.val = num % 10;
                if (num > 9 || list2.next != null) {
                    node.next = new ListNode(num / 10);
                }
                node = node.next;
                list2 = list2.next;
            }

            if (list1 != null && list2 == null) {
                num = list1.val + node.val;
                node.val = num % 10;
                if (num > 9 || list1.next != null) {
                    node.next = new ListNode(num / 10);
                }
                node = node.next;
                list1 = list1.next;
            }

            if (list1 != null && list2 != null) {
                num = list1.val + list2.val + node.val;
                node.val = num % 10;
                if (num > 9 || list1.next != null || list2.next != null) {
                    node.next = new ListNode(num / 10);
                }
                node = node.next;
                list1 = list1.next;
                list2 = list2.next;
            }

        }
        return reusltNode;
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
