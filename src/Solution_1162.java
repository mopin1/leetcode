import java.util.LinkedList;
import java.util.Queue;

class Solution_1162 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int res = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, findNearestLand(i, j));
                }
            }
        }
        return res;
    }

    public int findNearestLand(int x, int y) {
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        vis[x][y] = true;
        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = f[0] + dx[i], ny = f[1] + dy[i];
                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    continue;
                }
                if (!vis[nx][ny]) {
                    queue.offer(new int[]{nx, ny, f[2] + 1});
                    vis[nx][ny] = true;
                    if (grid[nx][ny] == 1) {
                        return f[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
