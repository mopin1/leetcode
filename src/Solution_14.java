class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int min_length = Integer.MAX_VALUE;
        for (String str : strs) {
            min_length = Math.min(min_length, str.length());
        }
        String s = strs[0];
        for (int i = 0, j; i < min_length; i++) {
            for (j = 1; j < strs.length; j++) {
                if (!(s.charAt(i) == strs[j].charAt(i)))
                    return sb.toString();
            }
            if (j == strs.length)
                sb.append(Character.toString(s.charAt(i)));
        }
        return sb.toString();
    }
}
