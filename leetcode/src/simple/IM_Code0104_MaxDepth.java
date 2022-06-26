package simple;

public class IM_Code0104_MaxDepth {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(1);
        System.out.println(maxDepth(p));

    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
