package a.leetcode;

/**
 * @Description
 * https://leetcode-cn.com/problems/hamming-distance/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class HammingDis {
    public static void main(String[] args) {
        int x=1,y=4;
        int res1 = 2;
        int res2 = hammingDistance(x,y);
        System.out.println(res1 == res2);
    }
    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        String bytes = Integer.toBinaryString(res);
        int sum=0;
        String[] bits = bytes.split("");
        for (String bit : bits) {
            sum += Integer.parseInt(bit);
        }
        return sum;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
