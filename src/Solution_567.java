class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] count = new int[26];
        char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray();
        for (char c : ch1)
            count[c - 'a']++;
        for (int i = 0; i <= s2.length() - n; i++) {
            if (count[ch2[i] - 'a'] != 0) {
                int j = i;
                int[] nums = new int[26];
                while (j < i + n) {
                    nums[ch2[j] - 'a']++;
                    j++;
                }
                if (check(count, nums))
                    return true;
            }
        }
        return false;
    }

    private boolean check(int[] count, int[] nums) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != nums[i])
                return false;
        }
        return true;
    }
}
