package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class ResetArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] rs1 = {2, 3, 5, 4, 1, 7};

        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] rs2 = {1, 4, 2, 3, 3, 2, 4, 1};

        int[] nums3 = {1, 1, 2, 2};
        int n3 = 2;
        int[] rs3 = {1, 2, 1, 2};

        System.out.println(Arrays.equals(shuffle(nums, n),rs1));
        System.out.println(Arrays.equals(shuffle(nums2, n2),rs2));
        System.out.println(Arrays.equals(shuffle(nums3, n3),rs3));

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] x = Arrays.copyOfRange(nums, 0, n);
        int[] y = Arrays.copyOfRange(nums, n, nums.length);

        for (int i = 0; i < n; i++) {
            nums[2 * i] = x[i];
            nums[2 * i + 1] = y[i];
        }
        return nums;
    }
}
