package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/count-primes/
 **/
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10) == 4);
        System.out.println(countPrimes(0) == 0);
        System.out.println(countPrimes(1) == 0);
    }
    public static int countPrimes(int n) {
        if(n <= 1) return 0;
        int[] rec = new int[n];
        Arrays.fill(rec,1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(rec[i] == 1){
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                rec[i * j] = 0;
            }
        }
        return count;
    }
}
