package a.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class TreeNode {
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
