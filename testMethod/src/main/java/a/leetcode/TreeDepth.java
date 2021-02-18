package a.leetcode;

import java.util.Objects;

/**
 * @Description
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node17 = new TreeNode(17);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node15;

        int res = 3;
        int res2 = maxDepth(root);
        System.out.println(res == res2);

    }
    public static int maxDepth(TreeNode root) {
        if(Objects.isNull(root)) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
