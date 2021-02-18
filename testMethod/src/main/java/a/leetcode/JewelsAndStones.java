package a.leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.stream.Stream;

/**
 * @Description
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int r1 = 3;
        String J2 = "z", S2 = "ZZ";
        int r2 = 0;

        System.out.println(numJewelsInStones(J,S) == r1);
        System.out.println(numJewelsInStones(J2,S2) == r2);
    }


    public static int numJewelsInStonesStream(String jewels, String stones) {
        Stream<String> stone = Stream.of(stones.split("")).parallel();
        long count = stone.filter(jewels::contains).count();
        return (int) count;
    }

    public static int numJewelsInStones2(String jewels, String stones) {
        String[] stone = stones.split("");
        int count = 0;
        for (String s : stone) {
            if(jewels.contains(s)) count++;
        }
        return count;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if(jewels.indexOf(c)>=0) count++;
        }
        return count;
    }

}
