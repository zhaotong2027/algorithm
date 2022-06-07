package Class09_Tree3;

import Class07_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code02_LeafNode2 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(4);
        head.right = new TreeNode(1);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(7);

        System.out.println(pathSum(head, 6));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(ans, new ArrayList<>(), root, 0, targetSum);
        return ans;
    }

    public static void process(List<List<Integer>> ans, List<Integer> path, TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            System.out.println(x.val + preSum);
            if (x.val + preSum == sum) {
                path.add(x.val);
                ans.add(copy(path));  // 按引用传递，直接添加path，会导致列表里的所有的path都显示最终程序跑完path值
                path.remove(path.size() - 1);  // 删掉最后一个，恢复现场，按引用传递
            }
//            preSum = 0;  // 不用恢复现场，按值传递
            return;
        }

        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(ans, path, x.left, preSum, sum);
        }
        if (x.right != null) {
            process(ans, path, x.right, preSum, sum);
        }
        path.remove(path.size() - 1);  // 删掉最后一个，在每个节点要跳转到下一个分支的节点时，需要恢复现场
    }


    public static List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer i : path) {
            ans.add(i);

        }
        return ans;
    }
}
