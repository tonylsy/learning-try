package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class RotateTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node22 = new TreeNode(2);
        TreeNode node77 = new TreeNode(7);
        TreeNode node1111 = new TreeNode(1);
        TreeNode node3333 = new TreeNode(3);
        TreeNode node6666 = new TreeNode(6);
        TreeNode node9999 = new TreeNode(9);
        root.left = node22;
        root.right = node77;
        node22.left = node1111;
        node22.right = node3333;
        node77.left = node6666;
        node77.right = node9999;

        TreeNode newTree = invertTree(root);

        TreeNode root1 = new TreeNode(4);
        TreeNode node221 = new TreeNode(2);
        TreeNode node771 = new TreeNode(7);
        TreeNode node11111 = new TreeNode(1);
        TreeNode node33331 = new TreeNode(3);
        TreeNode node66661 = new TreeNode(6);
        TreeNode node99991 = new TreeNode(9);
        root1.right = node221;
        root1.left = node771;
        node221.right = node11111;
        node221.left = node33331;
        node771.right = node66661;
        node771.left = node99991;

        System.out.println(TreeNode.compareTree(root1,newTree));

    }


    public static TreeNode invertTree(TreeNode root) {
        if(Objects.isNull(root)) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
