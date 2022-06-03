package Class07_Tree;

public class Code01_BinaryTree {

    // 递归序
    // 第一次到达这个节点打印就是先序打印，第一次未调到 f(head.left);
    // 第二次到达这个节点打印就是中序打印，第二次未调到 f(head.right);
    // 第三次到达这个节点打印就是 后序打印，第三次 调完  f(head.right);
    // 整个过程是：1 2 4 4(左，返回) 4(右，返回) 2 5 5 5 2 1 3 6 6 6 3 7 7 7 3 1
    // 都打印第一次 1 2 4 5 3 6 7 先序
    // 都打印第二次 4 2 5 1 6 3 7 中序
    // 都打印第三次 4 5 2 6 7 3 1 后序
    // 任何节点都到3次
    public static void f(TreeNode head) {
        while (head == null) {
            return;
        }
        // 1、此处打印，先序遍历
        f(head.left);
        // 2、此处打印，中序遍历
        f(head.right);
        // 3、此处打印，后序遍历
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        post(head);
    }


    // 前序遍历：根结点 ---> 左子树 ---> 右子树
    public static void pre(TreeNode head) {
        while (head == null) {
            return;
        }
        System.out.print(head.val + ",");
        pre(head.left);
        pre(head.right);
    }

    // 中序遍历：左子树---> 根结点 ---> 右子树
    public static void in(TreeNode head) {
        while (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.val + ",");
        in(head.right);
    }

    // 后序遍历：左子树 ---> 右子树 ---> 根结点
    public static void post(TreeNode head) {
        while (head == null) {
            return;
        }
        post(head.left);
        post(head.right);
        System.out.print(head.val);
    }
}
