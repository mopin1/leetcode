import java.util.Arrays;
import java.util.Comparator;

class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==1||n==0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        for(int i = 0, j = 1; j<n;){
            if(intervals[i][1]<=intervals[j][0]){
                i=j;j++;
            }else{
                count++;j++;
            }
        }
        return count;
    }
}

