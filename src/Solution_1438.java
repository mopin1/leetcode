import java.util.TreeMap;

class Solution_1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
