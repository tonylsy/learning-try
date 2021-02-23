package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class MergeLinkAsc {
    public static void main(String[] args) {
        ListNode headA = ListNode.createList(new int[]{1,2,4});
        ListNode headB = ListNode.createList(new int[]{1,3,4});
        ListNode right = ListNode.createList(new int[]{1,1,2,3,4,4});
        System.out.println(ListNode.compareTo(mergeTwoLists(headA,headB),right));

        ListNode headA2 = ListNode.createList(new int[]{});
        ListNode headB2 = ListNode.createList(new int[]{});
        ListNode right2 = ListNode.createList(new int[]{});
        System.out.println(ListNode.compareTo(mergeTwoLists(headA2,headB2),right2));

        ListNode headA3 = ListNode.createList(new int[]{});
        ListNode headB3 = ListNode.createList(new int[]{0});
        ListNode right3 = ListNode.createList(new int[]{0});
        System.out.println(ListNode.compareTo(mergeTwoLists(headA3,headB3),right3));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode current = newList;
        while(Objects.nonNull(l1) && Objects.nonNull(l2)){
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1 <= val2){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = Objects.isNull(l1)?l2:l1;
        return newList.next;
    }
}
