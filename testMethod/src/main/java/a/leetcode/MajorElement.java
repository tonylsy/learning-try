package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description
 **/
public class MajorElement {
    public static void main(String[] args) {
        int[] a1 = new int[]{3,2,3};
        int[] a2 = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(a1) == 3);
        System.out.println(majorityElement(a2) == 2);
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
