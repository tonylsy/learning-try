package a.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class GoodNumPair {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1,1,3};
        int r1 = 4;

        int[] nums2 = {1,1,1,1};
        int r2 = 6;

        int[] nums3 = {1,2,3};
        int r3 = 0;

        System.out.println(numIdenticalPairs(nums1) == r1);
        System.out.println(numIdenticalPairs(nums2) == r2);
        System.out.println(numIdenticalPairs(nums3) == r3);

    }


    public static int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        boolean[] checked = new boolean[nums.length];
        checked[0] = true;
        for (int j = 0; j < nums.length; j++) {
            if(!checked[j] || j == 0){
                int sameIntNum = 1;
                for (int i = j+1; i < nums.length; i++) {
                    if(!checked[i]){
                        if(nums[j] == nums[i]){
                            sameIntNum++;
                            checked[i] = true;
                        }
                    }
                }
                pairs += (sameIntNum * (sameIntNum-1)) / 2;
            }
        }
        return pairs;
    }

    public int numIdenticalPairs2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
