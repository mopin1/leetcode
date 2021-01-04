import java.util.Arrays;

class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int[] square_nums = new int[max_square_index];
        for (int i = 1; i < max_square_index; i++) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < max_square_index; j++) {
                if (i < square_nums[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[j]] + 1);
            }
        }
        return dp[n];
    }
}
