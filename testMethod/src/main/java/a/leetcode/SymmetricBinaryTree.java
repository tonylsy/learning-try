package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root33 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root44 = new TreeNode(4);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root44;
        root2.left = root4;
        root2.right = root33;

        System.out.println(isSymmetric(root));//true


        TreeNode root111 = new TreeNode(1);
        TreeNode root1111 = new TreeNode(2);
        TreeNode root211 = new TreeNode(2);
        TreeNode root311 = new TreeNode(3);
        TreeNode root3311 = new TreeNode(3);
        root111.left = root1111;
        root111.right = root211;
        root1111.right = root311;
        root211.right = root3311;
        System.out.println(isSymmetric(root111));//false
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null) return right == null;
        return isChildSymmetric(left,right);
    }

    private static boolean isChildSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2 == null;
        } else {
            if(node2 == null) return false;
            if (node1.val == node2.val) {
                return isChildSymmetric(node1.left, node2.right) && isChildSymmetric(node1.right, node2.left);
            } else {
                return false;
            }
        }
    }
}
