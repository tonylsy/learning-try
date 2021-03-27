package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 **/
public class OrderTwoSum {
    public static void main(String[] args) {
        int[] n1 = new int[]{2,7,11,15};
        int t1 = 9;
        System.out.println(Arrays.toString(twoSum(n1, t1)));//[1,2]

        int[] n2 = new int[]{2,3,4};
        int t2 = 6;
        System.out.println(Arrays.toString(twoSum(n2, t2)));//[1,3]

        int[] n3 = new int[]{0,-1};
        int t3 = -1;
        System.out.println(Arrays.toString(twoSum(n3, t3)));//[1,2]

    }
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0) return null;
        int[] rs = new int[2];
        if(numbers.length == 1) {
            if(numbers[0] == target){
                return rs;
            }else{
                return null;
            }
        }
        int left=0,right=numbers.length - 1;
        while(left < right){
            int res = numbers[left] + numbers[right];
            if(res == target){
                rs[0] = left + 1;
                rs[1] = right + 1;
                return rs;
            }else if(res > target){
                right--;
            }else {
                left++;
            }
        }
        return null;
    }
}
