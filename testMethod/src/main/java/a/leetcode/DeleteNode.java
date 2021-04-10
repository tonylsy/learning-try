package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/remove-linked-list-elements/
 **/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(ListNode.compareTo(removeElements(head, 6), ListNode.createList(new int[]{1, 2, 3, 4, 5})));
        ListNode head2 = ListNode.createList(new int[]{});
        System.out.println(ListNode.compareTo(removeElements(head2, 1), ListNode.createList(new int[]{})));
        ListNode head3 = ListNode.createList(new int[]{7,7,7,7});
        System.out.println(ListNode.compareTo(removeElements(head3, 7), null));
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            if (current.val == val) {
                if (current.next == null) {
                    if(pre == null){
                        head = null;
                    }else{
                        pre.next = null;
                    }
                    current = null;
                } else {
                    current.val = current.next.val;
                    current.next = current.next.next;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }
}
