package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 **/
public class FindNearestAncestor {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(6);
        TreeNode r12 = new TreeNode(2);
        TreeNode r18 = new TreeNode(8);
        TreeNode r10 = new TreeNode(0);
        TreeNode r14 = new TreeNode(4);
        TreeNode r13 = new TreeNode(3);
        TreeNode r15 = new TreeNode(5);
        TreeNode r17 = new TreeNode(7);
        TreeNode r19 = new TreeNode(9);
        r1.left = r12;
        r1.right = r18;
        r18.left = r17;
        r18.right = r19;
        r12.left = r10;
        r12.right = r14;
        r14.left = r13;
        r14.right = r15;

        TreeNode a1 = lowestCommonAncestor(r1,r12,r18);
        assert a1 != null;
        System.out.println(a1.val == 6);

        TreeNode a2 = lowestCommonAncestor(r1,r12,r14);
        assert a2 != null;
        System.out.println(a2.val == 2);
    }



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(current!=null){
            int value = current.val;
            int pValue = p.val;
            int qValue = q.val;
            if(value > pValue && value > qValue){
                current = current.left;
                continue;
            }
            if(value < pValue && value < qValue){
                current = current.right;
            }
            boolean getA1 = value < pValue && value > qValue;
            boolean getA2 = value > pValue && value < qValue;
            if(getA1 || getA2){
                return current;
            }
            if(value == pValue || value == qValue){
                return current;
            }

        }
        return null;
    }
}
