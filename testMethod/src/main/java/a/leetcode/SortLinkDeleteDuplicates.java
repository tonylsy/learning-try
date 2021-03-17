package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 **/
public class SortLinkDeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        ListNode head22 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head22.next = node22;

        System.out.println(ListNode.compareTo(deleteDuplicates(head),head22));//true

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node31 = new ListNode(2);
        ListNode node41 = new ListNode(3);
        ListNode node51 = new ListNode(3);
        head1.next = node11;
        node11.next = node31;
        node31.next = node41;
        node41.next = node51;

        ListNode head133 = new ListNode(1);
        ListNode node3133 = new ListNode(2);
        ListNode node4133 = new ListNode(3);
        head133.next = node3133;
        node3133.next = node4133;

        System.out.println(ListNode.compareTo(deleteDuplicates(head1),head133));//true

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode before=head,current;
        if(before == null) return null;
        if(before.next == null) return before;
        current = before.next;
        while(current!=null){
            if(before.val == current.val){
                before.next = current.next;
            }else{
                before = current;
            }
            current = current.next;
        }
        return head;
    }
}
