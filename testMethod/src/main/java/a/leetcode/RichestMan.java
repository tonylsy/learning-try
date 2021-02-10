package a.leetcode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class RichestMan {

    public static void main(String[] args) {
        performanceTest();
    }

    public static void performanceTest() {
        int[][] accounts = new int[10000][10000];
        Random r = new Random();
        for (int[] account : accounts) {
            for (int i = 0; i < account.length; i++) {
                account[i] = r.nextInt();
            }
        }

        LocalTime starter =LocalTime.now();
        maximumWealth(accounts);
        LocalTime end1 =LocalTime.now();

        maxW1(accounts);
        LocalTime end2 =LocalTime.now();

        maxW2(accounts);
        LocalTime end3 =LocalTime.now();

        System.out.println(Duration.between(starter,end1).toMillis());
        System.out.println(Duration.between(end1,end2).toMillis());
        System.out.println(Duration.between(end2,end3).toMillis());

    }

    public static void leetCodeTest() {
        int[][] a1 = {{1, 2, 3}, {3, 2, 1}};
        int[][] a2 = {{1, 5}, {7, 3}, {3, 5}};
        int[][] a3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};

        int r1 = 6;
        int r2 = 10;
        int r3 = 17;

        System.out.println(maximumWealth(a1) == r1);
        System.out.println(maximumWealth(a2) == r2);
        System.out.println(maximumWealth(a3) == r3);

        System.out.println(maxW1(a1) == r1);
        System.out.println(maxW1(a2) == r2);
        System.out.println(maxW1(a3) == r3);

        System.out.println(maxW2(a1) == r1);
        System.out.println(maxW2(a2) == r2);
        System.out.println(maxW2(a3) == r3);
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static int maxW1(int[][] accounts) {
        return Arrays.stream(accounts).map(account -> Arrays.stream(account).sum()).max(Integer::compareTo).get();
    }

    public static int maxW2(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j : account) {
                sum += j;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
