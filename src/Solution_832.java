class Solution_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] x : A) {
            int i = 0, j = n - 1;
            while (i < j) {
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                i++;
                j--;
            }
            for (int k = 0; k < n; k++) {
                if (x[k] == 1) x[k] = 0;
                else x[k] = 1;
            }
        }
        return A;
    }
}
