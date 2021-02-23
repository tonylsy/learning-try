package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/maximum-subarray/
 * tricky 在于只要当前元素比之前的所有元素和要大，那么直接把之前的和抛弃
 **/
public class SumChildArray {
    public int maxSubArray(int[] nums){
        int previousSum=0,maxSum = nums[0];
        for (int num : nums) {
            previousSum = Math.max(previousSum + num,num);
            maxSum = Math.max(previousSum,maxSum);
        }
        return maxSum;
    }
}
