class Solution_9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reserveNum = 0;
        while (x>reserveNum){
            reserveNum = reserveNum * 10 + x%10;
            x/=10;
        }
        return x==reserveNum || x == reserveNum/10;
    }
}
