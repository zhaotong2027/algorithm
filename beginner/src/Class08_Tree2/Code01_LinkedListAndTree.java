package Class08_Tree2;

import Class07_Tree.TreeNode;

import java.util.*;

public class Code01_LinkedListAndTree {
    public static void main(String[] args) {
        int testTime = 100000;
        long start;
        long end;
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        start = System.currentTimeMillis();
//        for (int i = 0; i < testTime; i++) {
//            arr1.add(0, i);
//        }
//        end = System.currentTimeMillis();
//        System.out.println(end - start);
//
//        start = System.currentTimeMillis();
//        LinkedList<Integer> arr2 = new LinkedList<>();
//        for (int i = 0; i < testTime; i++) {
//            arr2.add(0, i);
//        }
//        end = System.currentTimeMillis();
//        System.out.println(end - start);

//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);
//        System.out.println(levelOrderBottom(head).toString());
//        System.out.println(levelOrderBottom2(head).toString());

        Stack<Integer> stack = new Stack<>();  // 栈结构可以实例化，但本身非常慢， 推荐用链表双端队列实现
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            stack.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);


        LinkedList<Integer> linkedList = new LinkedList<>();  // 比较快
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            linkedList.addLast(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);


        int[] ints = new int[testTime];  // 定长，最快
        int index = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            ints[index++] = i;
        }
        while (index != 0) {
            int j = ints[--index];
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curAns);  // 链表都在0位置加，已有的就会往后放，不会被覆盖掉
        }

        return ans;
    }

    // 默写
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();  // interface，任何符合结构的都可实现
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curAns = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curAns.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(0, curAns);
        }

        return ans;
    }
}
