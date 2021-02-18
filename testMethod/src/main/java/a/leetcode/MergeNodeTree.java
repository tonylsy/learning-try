package a.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/merge-two-binary-trees/
 **/
public class MergeNodeTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;

        TreeNode root2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        root2.left = node4;
        root2.right = node5;
        node4.right = node6;
        node5.right = node7;


        TreeNode rs = new TreeNode(3);
        TreeNode node44 = new TreeNode(4);
        TreeNode node55 = new TreeNode(5);
        TreeNode node555 = new TreeNode(5);
        TreeNode node444 = new TreeNode(4);
        TreeNode node777 = new TreeNode(7);
        rs.left = node44;
        rs.right = node55;
        node44.left = node555;
        node44.right = node444;
        node55.right = node777;

        TreeNode rs2 = mergeTrees(root1,root2);

        System.out.println(TreeNode.compareTree(rs,rs2));

    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode mergedNode = new TreeNode(root1.val + root2.val);
        mergedNode.left = mergeTrees(root1.left, root2.left);
        mergedNode.right = mergeTrees(root1.right,root2.right);
        return mergedNode;
    }

    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(Objects.isNull(root2)){
            return root1;
        }else if(Objects.isNull(root1)){
            return root2;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            node1.val += node2.val;
            if (Objects.nonNull(node1.right)) {
                stack1.push(node1.right);
                if (Objects.nonNull(node2.right)) {
                    stack2.push(node2.right);
                } else {
                    stack2.push(new TreeNode(0));
                }
            } else {
                if (Objects.nonNull(node2.right)) {
                    node1.right = node2.right;
                }
            }
            if (Objects.nonNull(node1.left)) {
                stack1.push(node1.left);
                if (Objects.nonNull(node2.left)) {
                    stack2.push(node2.left);
                } else {
                    stack2.push(new TreeNode(0));
                }
            } else {
                if (Objects.nonNull(node2.left)) {
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }
}
