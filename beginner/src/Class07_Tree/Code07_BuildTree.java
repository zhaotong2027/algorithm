package Class07_Tree;

import java.util.HashMap;

public class Code07_BuildTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        TreeNode head = buildTree(pre, in);
        System.out.println();
        pre(head);
        System.out.println();
        in(head);
        System.out.println();
    }

    // 前序遍历：根结点 ---> 左子树 ---> 右子树
    public static void pre(TreeNode head) {
        while (head == null) {
            return;
        }
        System.out.print(head.val + ",");
        pre(head.left);
        pre(head.right);
    }

    // 中序遍历：左子树---> 根结点 ---> 右子树
    public static void in(TreeNode head) {
        while (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.val + ",");
        in(head.right);
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueOfIn = new HashMap();
        for (int i = 0; i < in.length; i++) {
            valueOfIn.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueOfIn);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (in[find] != pre[L1]) {
            find++;
        }
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);

        return head;
    }

    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueOfIn) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = valueOfIn.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueOfIn);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueOfIn);

        return head;
    }
}
