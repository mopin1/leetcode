import java.util.HashSet;
import java.util.Set;

class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums1)
            set.add(x);
        for (int x : nums2){
            if (set.contains(x))
                res.add(x);
        }
        int[] arr = new int[res.size()];
        Integer[] temp = res.toArray(new Integer[]{});
        for (int i = 0;i<temp.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
}
