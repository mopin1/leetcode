import java.util.ArrayList;
import java.util.List;

class Solution_interview_08_09 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        choose(0, 0, n, new StringBuilder());
        return res;
    }

    private void choose(int left, int right, int n, StringBuilder sb) {
        if (left == right && left == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            StringBuilder sbLeft = new StringBuilder(sb);
            sbLeft.append("(");
            choose(left + 1, right, n, sbLeft);
        }
        if (left > right) {
            StringBuilder sbRight = new StringBuilder(sb);
            sbRight.append(")");
            choose(left, right + 1, n, sbRight);
        }
    }
}
