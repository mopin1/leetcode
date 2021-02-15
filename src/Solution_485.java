class Solution_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(count, res);
                count = 0;
            }
        }
        return Math.max(res, count);
    }
}
