class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += cost[end];
            if (sum > maxCost) {
                sum -= cost[start];
                start += 1;
            }
            end += 1;
        }
        return end - start;
    }
}