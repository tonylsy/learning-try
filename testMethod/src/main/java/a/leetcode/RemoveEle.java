package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/remove-element/
 **/
public class RemoveEle {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(arr1,val) == 2);
    }


    public static int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int i = 0;
        while(i <= last){
            if(nums[i] == val){
                nums[i] = nums[last];
                last--;
            }else{
                i++;
            }
        }
        return i;
    }
}
