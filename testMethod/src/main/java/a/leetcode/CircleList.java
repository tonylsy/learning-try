package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class CircleList {
    public static void main(String[] args) {
        ListNode headA = new ListNode(3);//true
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA0 = new ListNode(0);
        ListNode nodeA4 = new ListNode(-4);
        headA.next = nodeA2;
        nodeA2.next = nodeA0;
        nodeA0.next = nodeA4;
        nodeA4.next = nodeA2;

        System.out.println(hasCycle(headA));

        ListNode headB = new ListNode(1);//true
        ListNode nodeB1 = new ListNode(2);
        headB.next = nodeB1;
        nodeB1.next = headB;

        System.out.println(hasCycle(headB));

        ListNode headC = new ListNode(1);//false
        System.out.println(hasCycle(headC));

    }

    public static boolean hasCycle(ListNode head) {
        try {
            ListNode slow = head;
            ListNode fast = head.next;
            while (!slow.equals(fast)) {
                slow = slow.next;
                fast = fast.next.next;
            }
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }
}
