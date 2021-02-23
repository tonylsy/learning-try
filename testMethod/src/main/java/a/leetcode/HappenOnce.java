package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/single-number/
 **/
public class HappenOnce {
    public static void main(String[] args) {
        int[] a1 = new int[]{2,2,1};
        int[] a2 = new int[]{4,1,2,1,2};

        System.out.println(singleNumber(a1) == 1);
        System.out.println(singleNumber(a2) == 4);

    }
    public static int singleNumber(int[] nums) {
        int res=0;
        for (int num : nums) {
            res = num ^ res;
        }
        return res;
    }
}
