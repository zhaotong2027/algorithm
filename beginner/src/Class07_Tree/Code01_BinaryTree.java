package Class07_Tree;

import Class04_LinkedList.Code01_LinkedList;

public class Code01_BinaryTree {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);

    }

    // 前序遍历：根结点 ---> 左子树 ---> 右子树
//    中序遍历：左子树---> 根结点 ---> 右子树
//    后序遍历：左子树 ---> 右子树 ---> 根结点
    public static void pre(Node head) {
        while (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    private static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int v) {
            value = v;
        }
    }
}
