import java.util.ArrayList;
import java.util.List;

class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }
        int count = 0;
        boolean change = false;
        for (int i = 0;i<s.length();i++){
            rows.get(count).append(s.charAt(i));
            if (count == 0 || count == numRows -1) {
                change = !change;
            }
            count += change ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}
