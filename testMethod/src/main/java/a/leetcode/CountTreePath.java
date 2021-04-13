package a.leetcode;

import java.util.*;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/binary-tree-paths/
 **/
public class CountTreePath {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r2.right = r5;
        List<String> list = Arrays.asList("1->2->5", "1->3");
        List<String> res = binaryTreePaths(r1);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(res.get(i))) {
                System.out.println("fail!");
                break;
            }
        }
        System.out.println(list.size() == res.size());

    }

    public static List<String> paths = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        addNodes(root,"");
        return paths;
    }
    public static void addNodes(TreeNode root, String path){
        if(root.left == null && root.right ==null){
            paths.add(path + root.val);
        }
        if(root.left!=null){
            addNodes(root.left, path + root.val + "->");
        }
        if(root.right!=null){
            addNodes(root.right, path + root.val + "->");
        }
    }
}
