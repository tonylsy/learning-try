package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/path-sum/
 **/
public class TargetSumInTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        TreeNode root11 = new TreeNode(11);
        TreeNode root13 = new TreeNode(13);
        TreeNode root44 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root2 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        root.left = root4;
        root.right = root8;
        root4.left = root11;
        root11.left = root7;
        root11.right = root2;
        root8.left = root13;
        root8.right = root44;
        root44.right = root1;
        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum));//true

        TreeNode root111 = new TreeNode(1);
        TreeNode root2222 = new TreeNode(2);
        TreeNode root3333 = new TreeNode(3);
        root111.left = root2222;
        root111.right = root3333;
        int t2 = 5;
        System.out.println(hasPathSum(root111, t2));//false

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int nextTarget = targetSum - root.val;
        return hasPathSum(root.left,nextTarget) || hasPathSum(root.right,nextTarget);
    }
}
