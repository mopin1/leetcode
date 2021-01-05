class Solution_522 {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                if (j == i) continue;
                if (isSubsequence(strs[i], strs[j]))
                    break;
            }
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }

    private boolean isSubsequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (b.charAt(i) == a.charAt(j)) j++;
        }
        return j == a.length();
    }
}
