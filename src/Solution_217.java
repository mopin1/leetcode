import java.util.HashSet;
import java.util.Set;

class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        return set.size()!=nums.length;
    }
}
