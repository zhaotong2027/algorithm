package simple;

import java.util.ArrayList;
import java.util.List;

public class Code0144_PreOrderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        traversal(ans, root);
        return ans;
    }

    public static void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        // 前
        ans.add(root.val);
        traversal(ans, root.left);
        // 中
        traversal(ans,root.right);
        // 后
    }
}
