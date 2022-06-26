package simple;

/**
 * 二分的逆向
 *
 * 中序遍历：左->根->右，遍历整个树的过程中，第二次遇到到时才打印
 * 平衡二叉树：每个节点的左右两个子树的高度差的绝对值不超过 1
 * 搜索二叉树：每个根节点和左右子节点的关系为，左子节点比根节点小，右子节点比根节点大，中序遍历可以让所有节点有序
 *
 */
public class IM_Code0108_SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode head = sortedArrayToBST(nums);
        System.out.println();
        TreeNode.PrintInOrder(head);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return BST(nums, 0 , nums.length - 1);
    }

    public static TreeNode BST(int[] nums, int Left, int Right) {
        if (Left > Right) {
            return null;
        }
        int mid = Left + (Right - Left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, Left, mid - 1);
        root.right = BST(nums, mid + 1, Right);
        return root;
    }

}
