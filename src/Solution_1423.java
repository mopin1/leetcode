class Solution_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        int sumAll = 0;
        for (int x : cardPoints)
            sumAll += x;
        return sumAll - minSum;
    }
}