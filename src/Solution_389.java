import java.util.Arrays;

class Solution_389 {
    public char findTheDifference(String s, String t) {
        char[] chs = sort(s);
        char[] cht = sort(t);
        char res = '0';
        for(int i=0;i<cht.length;i++){
            if(i==cht.length-1){
                res = cht[cht.length-1];
                break;
            }
            if(chs[i]!=cht[i]){
                res = cht[i];
                break;
            }
        }
        return res;
    }
    private char[] sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return ch;
    }
}
