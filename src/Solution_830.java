import java.util.ArrayList;
import java.util.List;

class Solution_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = s.length();
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n) {
                if (s.charAt(i) == s.charAt(j)) j++;
                else break;
            }
            List<Integer> list = new ArrayList<>();
            if (j - i >= 3) {
                list.add(i);
                list.add(j - 1);
                res.add(list);
            }
            i = j;
        }
        return res;
    }
}
