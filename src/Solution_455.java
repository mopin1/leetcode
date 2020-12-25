import java.util.Arrays;

class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length,n=s.length;
        int count =0;
        for (int k : s) {
            for (int j = 0; j < m; j++) {
                if (g[j] <= k && g[j] > 0) {
                    count++;
                    g[j] = -1;
                    break;
                }
            }
        }
        return count;
    }
}