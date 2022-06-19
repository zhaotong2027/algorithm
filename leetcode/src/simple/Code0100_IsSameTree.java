package simple;

public class Code0100_IsSameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
//        p.right.left = new TreeNode(3);
//        p.right.right = new TreeNode(7);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
//        q.right.left = new TreeNode(3);
//        q.right.right = new TreeNode(7);

        System.out.println(isSameTree(p, q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
