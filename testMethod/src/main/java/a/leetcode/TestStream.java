package a.leetcode;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class TestStream {
    public static void main(String[] args) {
        learnStream();
    }

    public static void learnStream() {
        int[] account = new int[10000000];
        /*Random r = new Random();
        for (int i = 0; i < account.length; i++) {
            account[i] = r.nextInt();
        }*/
        Arrays.fill(account,20);

        LocalTime starter = LocalTime.now();
        int sum = 0;
        for (int j : account) {
            sum += j;
        }
        LocalTime end1 = LocalTime.now();

        int r2 = Arrays.stream(account).sum();
        assert(r2 == sum);
        LocalTime end2 = LocalTime.now();
/*
        int r3 = Arrays.stream(account).parallel().sum();
        assert(r3 == sum);
        LocalTime end3 = LocalTime.now();*/

        System.out.println("common sum:" + Duration.between(starter,end1).toMillis());
        System.out.println("common stream:" + Duration.between(end1,end2).toMillis());
        //System.out.println("parallel stream:" + Duration.between(end2,end3).toMillis());

    }
}

