package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n = n >> 1;
        }
        return res;
    }
}
