package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/balanced-binary-tree/
 **/
public class IsBalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);
        root.left = root9;
        root.right = root20;
        root20.left = root15;
        root20.right = root7;
        System.out.println(isBalanced(root));//true

        TreeNode root2 = new TreeNode(1);
        TreeNode root22 = new TreeNode(2);
        TreeNode root222 = new TreeNode(2);
        TreeNode root333 = new TreeNode(3);
        TreeNode root3333 = new TreeNode(3);
        TreeNode root444 = new TreeNode(4);
        TreeNode root4444 = new TreeNode(4);
        root2.left = root22;
        root2.right = root222;
        root22.left = root333;
        root22.right = root3333;
        root3333.left = root444;
        root3333.right = root4444;
        System.out.println(isBalanced(root2));//false

        TreeNode root3 = new TreeNode(1);
        TreeNode root32 = new TreeNode(2);
        TreeNode root33 = new TreeNode(3);
        root3.right = root32;
        root32.right = root33;
        System.out.println(isBalanced(root3));//false

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int distance = getHeight(root.left) - getHeight(root.right);
        return Math.abs(distance) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
