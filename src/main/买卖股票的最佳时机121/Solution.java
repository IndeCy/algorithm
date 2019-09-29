package 买卖股票的最佳时机121;

public class Solution {

    /**
     * 暴力求接法 时间复杂度O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int gap = prices[j] - prices[i];
                if(gap > maxPrice){
                    maxPrice = gap;
                }
            }
        }
        return maxPrice;
    }

    /**
     * 转化为求波峰和波谷的问题
     * 当最大利润更容易在波峰和波谷之间产生
     * @param prices
     * @return
     */
    public int maxProfitV2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


}
