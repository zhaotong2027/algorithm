package Class09_Tree3;

import Class07_Tree.TreeNode;

/**
 * 叶子节点：没有子节点的末端节点。
 * 路径：头节点开始，叶子节点结束
 */
public class Code01_LeafNode {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.right = new TreeNode(6);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(7);

        int sum = 10;
        hasPathSum(head, sum);
        System.out.println(isSum);
    }

    public static boolean isSum = false;
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return isSum;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    public static void process(TreeNode x, int preSum, int sum) {
        // 叶子节点
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }

        // 非叶子节点
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }
}
