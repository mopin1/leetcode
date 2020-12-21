class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];
        if(bills[0]!=5) return false;
        for(int x:bills){
            if(x==5) count[0]++;
            else if(x==10){
                if(count[0]!=0){
                    count[0]--;
                    count[1]++;
                }else{return false;}
            }else{
                if(count[0]>=1&&count[1]>=1){
                    count[0]--;
                    count[1]--;
                }else if(count[0]>=3){
                    count[0]-=3;
                }
                else return false;
            }
        }
        return true;
    }
}
