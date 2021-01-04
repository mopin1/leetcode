class Solution_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int min_m = m, min_n = n;
        for (int[] op : ops) {
            min_m = Math.min(min_m, op[0]);
            min_n = Math.min(min_n, op[1]);
        }
        return min_m * min_n;
    }
}
