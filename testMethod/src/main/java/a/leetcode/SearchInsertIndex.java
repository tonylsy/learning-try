package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
 **/
public class SearchInsertIndex {
    public static void main(String[] args) {
        int[] res1 = new int[]{1, 3, 5, 6};
        int t1 = 5;
        int t2 = 2;
        int t3 = 7;
        int t4 = 0;
        System.out.println(searchInsert(res1, t1) == 2);
        System.out.println(searchInsert(res1, t2) == 1);
        System.out.println(searchInsert(res1, t3) == 4);
        System.out.println(searchInsert(res1, t4) == 0);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
