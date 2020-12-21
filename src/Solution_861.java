class Solution_861 {
    public int matrixScore(int[][] A) {
        int n = A.length,m = A[0].length;
        for (int i =0;i<n;i++)
            if (A[i][0] == 0)
                change(A,i,true);

        for(int i = 0;i<m;i++){
            int j,count =0;
            for(j =0;j<n;j++)
                if(A[j][i]==0)
                    count++;

            if(count>=n/2+1) change(A,i,false);
        }
        int sum = 0;
        for (int[] ints : A)
            for (int j = 0; j < m; j++)
                sum += Math.pow(2, m - j - 1) * ints[j];

        return sum;
    }
    private void change(int[][] A,int k,boolean mode){
        if (mode) {
            for (int i = 0; i < A[k].length; i++)
                A[k][i] = A[k][i] == 0 ? 1 : 0;
        }else{
            for (int i =0;i<A.length;i++)
                A[i][k] = A[i][k] == 0 ? 1 : 0;
        }
    }
}
