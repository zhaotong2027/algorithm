package Class08_Tree2;

import Class07_Tree.TreeNode;

/**
 * 搜索二叉树：每个根节点的左节点都比根节点小，右节点都比根节点大
 * 中序遍历（左->根->右）结果递增，则一定符合搜索二叉树
 */
public class Code03_SearchTree {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(2);
//        head.left = new TreeNode(1);
//        head.right = new TreeNode(3);

        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.right = new TreeNode(6);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(7);

//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);

//        System.out.println(prosess(head).isSearch);
        System.out.println(prosess3(head));
    }

    public static boolean isSearchTree(TreeNode root) {
        return prosess3(root);
    }

    // ❌ 不同层级无法校验，需要找出子节点的最大最小值
    public static boolean prosess3(TreeNode x) {
        if (x == null) {
            return true;
        }
        if (x.left != null && x.left.val >= x.val) {
            return false;
        }
        if (x.right != null && x.val >= x.right.val) {
            return false;
        }
        prosess3(x.left);
        prosess3(x.right);
        return true;
    }

    public static Info prosess2(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = prosess2(x.left);
        Info rightInfo = prosess2(x.right);
        int min = x.val;
        int max = x.val;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isSearch = true;
        if (leftInfo != null && !leftInfo.isSearch) {
            isSearch = false;
        }
        if (rightInfo != null && !rightInfo.isSearch) {
            isSearch = false;
        }

        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);

        if (!(leftMaxLessX && rightMinMoreX)) {
            isSearch = false;
        }
        return new Info(isSearch, min, max);
    }

    public static Info prosess(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = prosess(x.left);
        Info rightInfo = prosess(x.right);
        int min = x.val;
        int max = x.val;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.max(leftInfo.max, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
        }
        boolean isSearch = false;
        boolean leftIsSearch = leftInfo == null ? true : leftInfo.isSearch;
        boolean rightIsSearch = rightInfo == null ? true : rightInfo.isSearch;

        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);

        if (leftIsSearch && rightIsSearch && leftMaxLessX && rightMinMoreX) {
            isSearch = true;
        }
        return new Info(isSearch, max, min);
    }

    public static class Info {
        public boolean isSearch;
        public int max;
        public int min;

        public Info(boolean i, int ma, int mi) {
            isSearch = i;
            max = ma;
            min = mi;
        }
    }
}
