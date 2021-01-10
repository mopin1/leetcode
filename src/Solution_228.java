import java.util.ArrayList;
import java.util.List;

class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = i - 1;
            StringBuilder temp = new StringBuilder();
            temp.append(nums[start]);
            if (start < end) {
                temp.append("->");
                temp.append(nums[end]);
            }
            res.add(temp.toString());
        }
        return res;
    }
}
