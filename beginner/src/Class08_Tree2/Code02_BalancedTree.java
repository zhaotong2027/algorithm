package Class08_Tree2;

import Class07_Tree.TreeNode;

/**
 * 平衡树：二叉树同一个根节点的子节点高度<=1
 * 就是说，根节点只有一个子节点，这个子节点必须没有子节点
 */
public class Code02_BalancedTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isBalanceTree(head));
    }

    public static boolean isBalanceTree(TreeNode root) {
//        while (root == null) {
//            return true;
//        }
//
//        Info info = process(root);
//        if (!info.isBalanced) {
//            return false;
//        }
//
//        System.out.println(root.val + " " + info.height);
//        isBalanceTree(root.left);
//        isBalanceTree(root.right);
        return process(root).isBalanced;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0);
        }

        Info left = process(x.left);
        Info right = process(x.right);

        int height = Math.max(left.height, right.height) + 1;

        boolean isBalanced = left.isBalanced && right.isBalanced
                && Math.abs(left.height - right.height) < 2;
        return new Info(isBalanced, height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }

    }
}
