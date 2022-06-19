package simple;

public class Code0101_IsSymmetricTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(1);
        System.out.println(isSymmetric(p));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    public static boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null ^ right == null) {
            return false;
        }
        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
    }
}
