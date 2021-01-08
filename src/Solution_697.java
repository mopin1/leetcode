import java.util.HashMap;
import java.util.Map;

class Solution_697 {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(map.get(num), max);
        }
        int min_length = n;
        for (int x : map.keySet()) {
            if (map.get(x) == max) {
                min_length = Math.min(find(nums, x, max), min_length);
            }
        }
        return min_length;
    }

    private int find(int[] nums, int x, int max) {
        int count = 0, start = 0, end = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x)
                count++;
            if (count == 1 && flag) {
                start = i;
                flag = false;
            }
            if (count == max) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}
