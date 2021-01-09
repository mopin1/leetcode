import java.util.*;

class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0)
            return res;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[n];
        Arrays.sort(nums);
        dfs(nums, res, 0, path, used, n);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int len, Deque<Integer> path, boolean[] used, int n) {
        if (len == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, res, len + 1, path, used, n);
            path.removeLast();
            used[i] = false;
        }
    }
}
