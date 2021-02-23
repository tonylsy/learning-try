package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 **/
public class BestTimeForStock {
    public static void main(String[] args) {
        int[] a1 = new int[]{7,1,5,3,6,4};
        int[] a2 = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(a1) == 5);
        System.out.println(maxProfit(a2) == 0);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfile=0;
        for (int price : prices) {
            minPrice = Math.min(minPrice,price);
            maxProfile = Math.max(maxProfile,price - minPrice);
        }
        return maxProfile;
    }

    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfile=0;
        for (int price : prices) {
            if(minPrice >= price){
                minPrice = price;
            }
            if(maxProfile <= price - minPrice){
                maxProfile = price - minPrice;
            }
        }
        return maxProfile;
    }
}
