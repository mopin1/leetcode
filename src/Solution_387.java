class Solution_387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int res = -1;
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1){
                res = i;
                break;
            }
        }
        return res;
    }
}
