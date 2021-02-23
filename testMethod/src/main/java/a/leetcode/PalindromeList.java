package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/palindrome-linked-list/
 **/
public class PalindromeList {
    public static void main(String[] args) {
        ListNode root = ListNode.createList(new int[]{1,2});
        ListNode root1 = ListNode.createList(new int[]{1,2,2,1});
        ListNode root2 = ListNode.createList(new int[]{1,0,1});
        ListNode root3 = ListNode.createList(new int[]{1,0,0});
        System.out.println(isPalindrome(root));//false
        System.out.println(isPalindrome(root1));//true
        System.out.println(isPalindrome(root2));//true
        System.out.println(isPalindrome(root3));//false
    }
    public static boolean isPalindrome(ListNode head) {
        if(Objects.isNull(head)) return true;
        if(Objects.isNull(head.next)) return true;
        ListNode half = head;
        ListNode fast = head;
        //find the middle of the list
        while(fast!=null){
            half = half.next;
            if(Objects.isNull(fast.next)){
                break;
            }
            fast = fast.next.next;
        }

        //reverse the last of the head
        ListNode previous= null,current=half,next;
        while(Objects.nonNull(current)){
            next = current.next;
            current.next = previous;
            //move the index
            previous = current;
            current = next;
        }

        while(Objects.nonNull(previous)) {
            if (head.val == previous.val) {
                head = head.next;
                previous = previous.next;
            } else {
                return false;
            }
        }

        return true;
    }
}
