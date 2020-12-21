import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_290 {
    public boolean wordPattern(String pattern, String s) {
        char[] ch = pattern.toCharArray();
        String[] str = s.split(" ");
        if(ch.length!=str.length)
            return false;
        Set<Character> set = new HashSet<>();
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<ch.length;i++){
            if(!set.contains(ch[i])){
                Set<String> co = new HashSet<>(map.values());
                if(co.contains(str[i])){
                    return false;
                }else{
                    set.add(ch[i]);
                    map.put(ch[i],str[i]);
                }
            }else{
                if(!str[i].equals(map.get(ch[i]))){
                    return false;
                }
            }
        }
        return true;
    }
}
