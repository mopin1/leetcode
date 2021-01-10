class Solution_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - leftSum * 2 == nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
