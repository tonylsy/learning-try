package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/move-zeroes/
 **/
public class MoveZeros {
    public static void main(String[] args) {
        int[] a1 = new int[]{0,1,0,3,12};
        moveZeroes(a1);
        System.out.println(Arrays.equals(a1,new int[]{1,3,12,0,0}));//true
    }

    public static void moveZeroes(int[] nums) {
        int noZeroIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[noZeroIndex] = nums[i];
                noZeroIndex++;
            }
        }
        for (int i = noZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
