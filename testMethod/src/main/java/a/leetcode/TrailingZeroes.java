package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));//0
        System.out.println(trailingZeroes(5));//1
        System.out.println(trailingZeroes(6));//1
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                count++;
                j = j / 5;
            }
        }
        return count;
    }
}
