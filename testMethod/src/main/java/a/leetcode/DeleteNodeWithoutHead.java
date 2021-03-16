package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 **/
public class DeleteNodeWithoutHead {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null){
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
