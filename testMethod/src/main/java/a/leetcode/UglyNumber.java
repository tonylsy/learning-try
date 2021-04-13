package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/ugly-number/
 **/
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(6));//ture
        System.out.println(isUgly(8));//ture
        System.out.println(isUgly(14));//false
        System.out.println(isUgly(1));//ture
    }
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }


    public static boolean isUgly2(int n) {
        if(n <= 0) return false;
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            } else if(n % 3 == 0){
                n /= 3;
            }else if(n % 5 == 0){
                n /= 5;
            }else{
                return false;
            }
        }
        return true;
    }
}
