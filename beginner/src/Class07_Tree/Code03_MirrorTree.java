package Class07_Tree;

public class Code03_MirrorTree {
    public static boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root, root);
    }

    public static boolean isMirrorTree(TreeNode p, TreeNode q) {
        // 一个空
        if (p == null ^ q == null) { // 异或
            return false;
        }
        // 都空
        if (p == null && q == null) {
            return true;
        }
        // 都不空
        return p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.right);
    }
}
