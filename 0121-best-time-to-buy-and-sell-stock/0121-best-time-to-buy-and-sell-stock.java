class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0], maxProfit = 0;

        for(int day = 1; day < prices.length; day++){
            int profitDay = prices[day] - min;
            maxProfit = Math.max(maxProfit, profitDay);
            min = Math.min(min, prices[day]);
        }
        return maxProfit;
    }
}