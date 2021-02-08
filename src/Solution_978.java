class Solution_978 {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0, right = 0;
        int res = 1;
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1])
                    left++;
                right++;
            } else {
                if ((arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) || (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]))
                    right++;
                else
                    left = right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
