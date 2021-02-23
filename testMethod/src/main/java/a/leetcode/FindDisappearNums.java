package a.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 **/
public class FindDisappearNums {

    public static void main(String[] args) {
        /*int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> rs = findDisappearedNumbers(arr);
        System.out.println(rs.contains(5));
        System.out.println(rs.contains(6));
        System.out.println(rs.size() == 2);*/

        int[] arr1 = new int[]{1,1};
        List<Integer> rs1 = findDisappearedNumbers(arr1);
        System.out.println(rs1.contains(2));
        System.out.println(rs1.size() == 1);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int number = (num - 1) % len;
            nums[number] += len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len){
                list.add(i+1);
            }
        }
        return list;
    }
}
