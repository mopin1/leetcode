class Solution_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        change(nums, 0, n - 1);
        change(nums, 0, k - 1);
        change(nums, k, n - 1);
    }

    private void change(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++;
            j--;
        }
    }
}
