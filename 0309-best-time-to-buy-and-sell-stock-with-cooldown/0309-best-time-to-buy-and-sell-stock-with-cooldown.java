class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> cache = new HashMap<>();
        return dfs(prices,cache,0,true);
    }

    public int dfs(int[] prices, Map<String,Integer> cache, int index, boolean buying){
        if(index>=prices.length){
            return 0;
        }

        String key = index+"-"+buying;

        if(cache.containsKey(key)){
            return cache.get(key);
                    }

        int cooldown= dfs(prices, cache, index+1, buying);
        int profitBuy0Sell = Integer.MIN_VALUE;

        if(buying){
            profitBuy0Sell = dfs(prices,cache,index+1,!buying) -prices[index];
        }else{
            profitBuy0Sell = dfs(prices,cache,index+2,!buying) + prices[index];
        }
        cache.put(key,Math.max(profitBuy0Sell,cooldown));
        return cache.get(key);


    }
}
/*
Make a tree of options. The worst case if we go through all possibilities is 2^n
But we can cache the results of known states.

*/