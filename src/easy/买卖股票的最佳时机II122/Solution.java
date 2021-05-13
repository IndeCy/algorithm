package easy.买卖股票的最佳时机II122;

public class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int valley;
        int peak;
        int i = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i+1]) i++;
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i+1]) i++;
            peak = prices[i];
            profit += (peak - valley);
        }
        return profit;
    }
}
