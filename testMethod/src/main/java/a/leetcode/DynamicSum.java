package a.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class DynamicSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 1, 1, 1, 1};
        int[] nums3 = {3, 1, 2, 10, 1};

        int[] r1 = {1, 3, 6, 10};
        int[] r2 = {1, 2, 3, 4, 5};
        int[] r3 = {3, 4, 6, 16, 17};

        System.out.println(Arrays.equals(r1,sum(nums1)));
        System.out.println(Arrays.equals(r2,sum(nums2)));
        System.out.println(Arrays.equals(r3,sum(nums3)));

    }


    public static int[] sum(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }
        return result;
    }
}
