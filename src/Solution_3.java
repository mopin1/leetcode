import java.util.HashSet;
import java.util.Set;

class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] count = new int[n];
        char[] ch = s.toCharArray();
        for (int i = 0; i < count.length; i++) {
            count[i] = len(i, ch);
        }
        int ans = 0;
        for (int x : count) {
            ans = Math.max(x, ans);
        }
        return ans;
    }

    private int len(int i, char[] ch) {
        int length = 1;
        Set<Character> set = new HashSet<>();
        set.add(ch[i]);
        for (int j = i + 1; j < ch.length; j++) {
            if (!set.contains(ch[j])) {
                set.add(ch[j]);
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}