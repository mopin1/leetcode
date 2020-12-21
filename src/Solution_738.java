class Solution_738 {
    public int monotoneIncreasingDigits(int N) {
        String n = String.valueOf(N);
        int[] num = new int[n.length()];
        for(int i =0;i<n.length();i++){
            num[i]=Integer.parseInt(Character.toString(n.charAt(i)));
        }
        if(n.length()==1) return N;
        int i;
        for(i =1;i<n.length();i++){
            if(num[i]<num[i-1]){
                for(int j=i-1;j>=0;j--){
                    if(j==0){
                        num[j]= Math.max(num[j] - 1, 0);
                        break;
                    }
                    if(num[j]-1<num[j-1]){
                        num[j]=9;
                    }else{
                        num[j]-=1;
                        break;
                    }
                }
                break;
            }
        }
        while(i<n.length()){
            num[i]=9;
            i++;
        }
        int res =0;
        for(int k=n.length()-1;k>=0;k--){
            res+=num[k]*Math.pow(10,n.length()-k-1);
        }
        return res;
    }
}
