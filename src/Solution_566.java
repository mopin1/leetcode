class Solution_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c)
            return nums;
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            res[x / c][x % c] = nums[x / n][x % n];
        }
        return res;
    }
}
