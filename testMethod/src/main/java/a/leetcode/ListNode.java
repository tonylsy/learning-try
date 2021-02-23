package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static boolean compareTo(ListNode root1, ListNode root2) {
        if (root1 == null) {
            return null == root2;
        }
        if (root1.equals(root2)) {
            compareTo(root1.next, root2.next);
        } else {
            return false;
        }
        return true;
    }
    static ListNode createList(int[] val){
        if(val.length == 0) return new ListNode();
        ListNode head = new ListNode(val[0]);
        ListNode current = head;
        for (int i = 1; i < val.length; i++) {
            current.next = new ListNode(val[i]);
            current = current.next;
        }
        return head;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
