class Solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < n - X + 1; i++) {
            int temp = 0, j = i;
            while (count < X) {
                if (grumpy[j] == 1)
                    temp += customers[j];
                count++;
                j++;
            }
            max = Math.max(temp, max);
            count = 0;
        }
        return sum + max;
    }
}
