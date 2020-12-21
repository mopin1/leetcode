class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 0) {
                            count++;
                        }
                    }
                    sum += count;
                }
            }
        }
        return sum;
    }
}
