import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> ha = new HashMap<>();
        for (int key : arr) {
            ha.put(key,ha.getOrDefault(key,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer,Integer> x:ha.entrySet()){
            set.add(x.getValue());
        }
        return ha.size()==set.size();
    }
}
