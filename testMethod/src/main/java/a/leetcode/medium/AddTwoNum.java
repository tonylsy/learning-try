package a.leetcode.medium;

import a.leetcode.ListNode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/add-two-numbers/
 **/
public class AddTwoNum {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createList(new int[]{5, 6, 4});
        ListNode r1 = ListNode.createList(new int[]{7, 0, 8});
        System.out.println(ListNode.compareTo(r1, addTwoNumbers(l1, l2)));

        ListNode l11 = ListNode.createList(new int[]{0});
        ListNode l21 = ListNode.createList(new int[]{0});
        ListNode r11 = ListNode.createList(new int[]{0});
        System.out.println(ListNode.compareTo(r11, addTwoNumbers(l11, l21)));

        ListNode l111 = ListNode.createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l211 = ListNode.createList(new int[]{9, 9, 9, 9});
        ListNode r111 = ListNode.createList(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        System.out.println(ListNode.compareTo(r111, addTwoNumbers(l111, l211)));

        ListNode l1111 = ListNode.createList(new int[]{0, 8, 8, 8, 8, 2, 9, 3, 1, 1});
        ListNode l2111 = ListNode.createList(new int[]{0, 9, 1, 5, 5, 5, 1, 1, 6});
        ListNode r1111 = ListNode.createList(new int[]{0, 7, 0, 4, 4, 8, 0, 5, 7, 1});
        System.out.println(ListNode.compareTo(r1111, addTwoNumbers(l1111, l2111)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode pre = new ListNode();
        int currentValue = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                currentValue += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentValue += l2.val;
                l2 = l2.next;
            }

            current.val += currentValue % 10;
            current.next = new ListNode(0);
            pre = current;
            current = current.next;

            if (currentValue >= 10) {
                currentValue = 1;
            } else {
                currentValue = 0;
            }
        }
        if (currentValue == 0) {
            pre.next = null;
        } else {
            current.val = currentValue;
        }
        return head;
    }
}
