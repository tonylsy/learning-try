package a.leetcode;

import java.util.Objects;
import java.util.Stack;

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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        static boolean compareTree(TreeNode root1, TreeNode root2) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root1);
            stack2.push(root2);
            try {
                while (!stack1.isEmpty()) {
                    TreeNode node1 = stack1.pop();
                    TreeNode node2 = stack2.pop();
                    if (!node1.equals(node2)) {
                        return false;
                    } else {
                        if (Objects.nonNull(node1.right)) {
                            stack1.push(node1.right);
                            stack2.push(node2.right);
                        }
                        if (Objects.nonNull(node1.left)) {
                            stack1.push(node1.left);
                            stack2.push(node2.left);
                        }
                    }
                }

            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }
}
