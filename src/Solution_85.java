class Solution_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int max=0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0] = matrix[i][0]-'0';
            for(int j=1;j<m;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=dp[i][j-1]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]>0){
                    int temp=dp[i][j];
                    for(int k=i;k>=0;k--){
                        if(dp[k][j]==0)
                            break;
                        int height = i-k +1;
                        temp = Math.min(temp,dp[k][j]);
                        max = Math.max(max,height*temp);
                    }
                }
            }
        }
        return max;
    }
}