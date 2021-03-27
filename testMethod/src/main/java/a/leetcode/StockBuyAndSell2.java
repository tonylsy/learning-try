package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/
public class StockBuyAndSell2 {
    public static void main(String[] args) {
        int[] p1 = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(p1) == 7);
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int part = prices[i] - prices[i-1];
            if(part >= 0){
                profit += part;
            }
        }
        return profit;
    }
}
