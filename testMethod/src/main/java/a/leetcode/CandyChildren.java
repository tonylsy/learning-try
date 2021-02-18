package a.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class CandyChildren {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> r1 = Arrays.asList(true,true,true,false,true);

        int[] candies2 = {4,2,1,1,2};
        int extraCandies2 = 1;
        List<Boolean> r2 = Arrays.asList(true,false,false,false,false);


        int[] candies3 = {12,1,12};
        int extraCandies3 = 10;
        List<Boolean> r3 = Arrays.asList(true,false,true);

        System.out.println(kidsWithCandies(candies,extraCandies).equals(r1));
        System.out.println(kidsWithCandies(candies2,extraCandies2).equals(r2));
        System.out.println(kidsWithCandies(candies3,extraCandies3).equals(r3));

    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            if(candy > max){
                max = candy;
            }
        }
        for (int candy : candies) {
            if(candy + extraCandies >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
