class Solution_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
