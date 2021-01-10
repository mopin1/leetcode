class Solution_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0, left = 0, right = k;
        for (int i = 0; i < k; i++)
            sum += arr[i];
        if (sum / k >= threshold)
            count++;
        while (left < arr.length - k) {
            sum = sum - arr[left] + arr[right];
            if (sum / k >= threshold)
                count++;
            left++;
            right++;
        }
        return count;
    }
}
