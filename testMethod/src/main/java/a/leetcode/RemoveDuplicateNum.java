package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class RemoveDuplicateNum {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 2};
        int res1 = 2;
        System.out.println(removeDuplicates(arr1) == res1);//true
        System.out.println(Arrays.toString(arr1));//{1,2,2}

        int[] arr2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res2 = 5;
        System.out.println(removeDuplicates(arr2) == res2);//true
        System.out.println(Arrays.toString(arr2));//{0,1,2,3,4,....}
    }


    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
