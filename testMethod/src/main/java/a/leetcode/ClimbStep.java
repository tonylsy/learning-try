package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/climbing-stairs/
 **/
public class ClimbStep {
    public static void main(String[] args) {
        System.out.println(climbStairs(2) == 2);
        System.out.println(climbStairs(3) == 3);
    }

    public static int climbStairs(int n) {
        int before=0,current=0,next=1;
        for (int i = 0; i < n; i++) {
            before = current;
            current = next;
            next = current + before;
        }
        return next;
    }

}
