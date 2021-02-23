package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description  https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class ReverseLink {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode node111 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        ListNode root2 = new ListNode(5);
        root2.next = node33;
        node33.next = node22;
        node22.next = node11;
        node11.next = node111;


        ListNode root3 = reverseList(root);
        System.out.println(ListNode.compareTo(root2,root3));
    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while(Objects.nonNull(current)){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

}
