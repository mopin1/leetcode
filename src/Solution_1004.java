class Solution_1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, lsum = 0, rsum = 0;
        int res = 0;
        while (right < A.length) {
            rsum += 1 - A[right];
            if (rsum - lsum > K) {
                lsum += 1 - A[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
