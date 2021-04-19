package a.leetcode;

/**
 * HappyNumber
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(getNext(19)==82);
        System.out.println(getNext(82)==68);
        System.out.println(getNext(68)==100);
        System.out.println(getNext(68)==100);
        System.out.println(getNext(100)==1);

        System.out.println(isHappy(19));//true
        System.out.println(isHappy(2));//false
    }

    public static boolean isHappy(int n) {
        if(n==1) return true;
        int slow = n;
        int fast = getNext(n);
        while(slow != fast){
            if(slow == 1 || fast == 1){
                return true;
            }
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return false;
    }

    private static int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int num = n % 10;
            next = next + num * num;
            n /= 10;
        }
        return next;
    }
}