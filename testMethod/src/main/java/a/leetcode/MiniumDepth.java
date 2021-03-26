package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 **/
public class MiniumDepth {
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
        System.out.println(minDepth(root) == 2);//true

        TreeNode root2 = new TreeNode(2);
        TreeNode root333 = new TreeNode(3);
        TreeNode root444 = new TreeNode(4);
        TreeNode root555 = new TreeNode(5);
        TreeNode root666 = new TreeNode(6);
        root2.right = root333;
        root333.right = root444;
        root444.right = root555;
        root555.right = root666;
        System.out.println(minDepth(root2) == 5);//true

    }
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null){
           return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
