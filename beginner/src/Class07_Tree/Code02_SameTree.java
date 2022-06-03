package Class07_Tree;

public class Code02_SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 一个空
        if (p == null ^ q == null) { // 异或
            return false;
        }
        // 都空
        if (p == null && q == null) {
            return true;
        }
        // 都不空
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.left, q.right);
    }
}
