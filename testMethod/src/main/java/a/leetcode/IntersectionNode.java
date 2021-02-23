package a.leetcode;

import java.util.Objects;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 **/
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);//Intersection point!
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        headA.next = node1;
        node1.next = node8;
        node8.next = node4;
        node4.next = node5;

        ListNode headB = new ListNode(5);
        ListNode nodeB0 = new ListNode(0);
        ListNode nodeB1 = new ListNode(1);
        headB.next = nodeB0;
        nodeB0.next = nodeB1;
        nodeB1.next = node8;

        ListNode res1 = getIntersectionNode(headA,headB);
        System.out.println(ListNode.compareTo(res1,node1));

        ListNode headAA = new ListNode(0);
        ListNode nodeAA9 = new ListNode(9);
        ListNode nodeAA1 = new ListNode(1);
        ListNode nodeAA2 = new ListNode(2);//Intersection point!
        ListNode nodeAA4 = new ListNode(4);
        headAA.next = nodeAA9;
        nodeAA9.next = nodeAA1;
        nodeAA1.next = nodeAA2;
        nodeAA2.next = nodeAA4;


        ListNode headBB = new ListNode(3);
        headBB.next = nodeAA2;

        ListNode res2 = getIntersectionNode(headAA,headBB);
        System.out.println(ListNode.compareTo(res2,nodeAA2));


        ListNode headAAA = new ListNode(2);
        ListNode nodeAAA6 = new ListNode(6);
        ListNode nodeAAA4 = new ListNode(4);
        headAAA.next = nodeAAA6;
        nodeAAA6.next = nodeAAA4;

        ListNode headBBB = new ListNode(1);
        headBBB.next = new ListNode(5);

        ListNode res3 = getIntersectionNode(headAAA,headBBB);
        System.out.println(res3 == null);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null? headB:pA.next;
            pB = pB == null? headA:pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode aEnd = null, bEnd = null, aCurrent = headA, bCurrent = headB;
        while (Objects.nonNull(aCurrent) && Objects.nonNull(bCurrent)) {
            if (aCurrent.equals(bCurrent)) {
                return aCurrent;
            }
            if (Objects.isNull(aCurrent.next)) {
                if (Objects.isNull(aEnd)) {
                    aEnd = aCurrent;
                } else {
                    return null;
                }
                aCurrent = headB;
            }else{
                aCurrent = aCurrent.next;
            }

            if (Objects.isNull(bCurrent.next)) {
                if (Objects.isNull(bEnd)) {
                    bEnd = bCurrent;
                } else {
                    return null;
                }
                bCurrent = headA;
            }else{
                bCurrent = bCurrent.next;
            }
        }
        return null;
    }
}
