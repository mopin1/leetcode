class Solution_494 {
    int count = 0;
    int S;

    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        sum(nums, 0, 0);
        return count;
    }

    private void sum(int[] nums, int i, int s) {
        if (i == nums.length) {
            if (s == S)
                count++;
        } else {
            sum(nums,i+1,s+nums[i]);
            sum(nums,i+1,s-nums[i]);
        }
    }
}
