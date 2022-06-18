package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历：左->中->右
 * 遍历整个树的过程中，第二次遇到到时才打印
 */
public class Code0094_InorderTraversal {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);
//        p.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(p));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return process(root, new ArrayList<>());
    }

    public static List<Integer> process(TreeNode root, List<Integer> ans) {
        if (root.left != null) {
            process(root.left, ans);
        }
        ans.add(root.val);
        if (root.right != null) {
            process(root.right, ans);
        }
        return ans;
    }
}
