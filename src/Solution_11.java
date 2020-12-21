class Solution_11 {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        for(int i=0,j=n-1;i<j;){
            int l = Math.min(height[i],height[j]);
            max = Math.max(max,l*(j-i));
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
