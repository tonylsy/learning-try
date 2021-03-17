package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/sqrtx/
 **/
public class SquareRootOfX {


    public int mySqrt(int x) {
        if (x == 0) return 0;
        int root = (int) Math.exp(0.5 * Math.log(x));
        //because the float to int would cut the bits, need check
        return (long) (root+1) * (root+1) <= x ? root + 1: root;
    }
}
