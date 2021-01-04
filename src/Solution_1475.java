class Solution_1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                if (prices[j] <= prices[i])
                    break;
                else j++;
            }
            if (j != n)
                res[i] = prices[i] - prices[j];
            else
                res[i] = prices[i];
        }
        return res;
    }
}
