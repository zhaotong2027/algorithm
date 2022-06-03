package Class06_Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.cn/problems/merge-k-sorted-lists/
public class Code03_mergeKLists {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        listNode11.next = listNode12;
        listNode11.next = listNode13;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;

        ListNode[] lists = {listNode11, listNode21, listNode31};
//        ListNode listNull = new ListNode();
//        lists = new ListNode[]{};
//        lists = new ListNode[]{listNull};


        ListNode listNode = mergeKLists(lists);
        System.out.println();
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();

    }

    // 列表有m个头节点，则堆里有m个节点，则堆的复杂度为 O(logM)
    // 总节点个数为n，每个节点都会进出堆，则时间复杂度为 O(2*logM)
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ValComparator());
        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.add(listNode);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
            System.out.print("cur:" + cur.val + " headNode:" + head.val + " pre:" + pre.val + " ");
            System.out.println();
        }
        return head;
    }

    // val 升序
    public static class ValComparator implements Comparator<ListNode> {
        // 返回正数 o1 在前
        // 返回负数 o2 在前
        // 返回0 两数相等
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
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
