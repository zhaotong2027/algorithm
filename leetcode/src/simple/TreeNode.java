package simple;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void PrintInOrder(TreeNode head) {
        while (head == null) {
            return;
        }
        // 1、此处打印，先序遍历
        PrintInOrder(head.left);
        // 2、此处打印，中序遍历
        System.out.print(head.val + ",");
        PrintInOrder(head.right);
        // 3、此处打印，后序遍历
    }
}
