class Solution_1137 {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 | n == 2)
            return 1;
        int tmp, t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            tmp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tmp;
        }
        return t2;
    }
}
