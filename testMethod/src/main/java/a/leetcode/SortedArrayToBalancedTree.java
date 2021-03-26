package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 **/
public class SortedArrayToBalancedTree {
    public static void main(String[] args) {
        SortedArrayToBalancedTree tree = new SortedArrayToBalancedTree();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        int[] nums2 = new int[]{1, 3};

        TreeNode root1 = new TreeNode(0);
        TreeNode root3 = new TreeNode(-3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root10 = new TreeNode(-10);
        TreeNode root5 = new TreeNode(5);
        root1.left = root3;
        root3.left = root10;
        root1.right = root9;
        root9.left = root5;
        System.out.println(TreeNode.compareTree(root1, tree.sortedArrayToBST(nums)));

        TreeNode root11 = new TreeNode(3);
        root11.left = new TreeNode(1);
        System.out.println(TreeNode.compareTree(root11, tree.sortedArrayToBST(nums2)));
    }

    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return createTree(0, nums.length);
    }

    // right would not create the node;
    private TreeNode createTree(int left, int right) {
        if(right - left < 1) return null;
        if(right - left == 1) return new TreeNode(nums[left]);
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(left, mid);
        root.right = createTree(mid + 1, right);
        return root;
    }
}
