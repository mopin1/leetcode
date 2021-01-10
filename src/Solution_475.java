import java.util.Arrays;

class Solution_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] a = new int[houses.length];
        int i = 0, j = 0;
        //max跟着循环走
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        while (i < houses.length) {
            if (j == heaters.length) {
                flag = true;
                break;
            }
            if (heaters[j] >= houses[i]) {
                if (j == 0)
                    a[i] = heaters[j] - houses[i];
                else
                    a[i] = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
                max = Math.max(max, a[i]);
                i++;
            } else
                j++;
        }
        //flag为true表示有房子的坐标比最后一个供暖器的坐标大
        if (flag) {
            //直接取最后一个房子到最后一个供暖器的距离
            max = Math.max(max, houses[houses.length - 1] - heaters[heaters.length - 1]);
        }
        return max;
    }
}
