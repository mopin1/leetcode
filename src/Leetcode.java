import java.util.*;

class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 0) {
                            count++;
                        }
                    }
                    sum += count;
                }
            }
        }
        return sum;
    }
}

class Solution_129 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

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

class Solution_845 {
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}

class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }
        int count = 0;
        boolean change = false;
        for (int i = 0;i<s.length();i++){
            rows.get(count).append(s.charAt(i));
            if (count == 0 || count == numRows -1) {
                change = !change;
            }
            count += change ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}

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

class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0;first<n;first++){
            // 需要和上一次枚举的数不相同
            if (first>0&&nums[first] == nums[first-1])
                continue;
            // c 对应的指针初始指向数组的最右端
            int third = n-1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first+1;second<n;second++){
                // 需要和上一次枚举的数不相同
                if (second>first+1&&nums[second]==nums[second-1])
                    continue;
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second<third && nums[second]+nums[third]>target){
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third)
                    break;
                if (nums[second]+nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums1)
            set.add(x);
        for (int x : nums2){
            if (set.contains(x))
                res.add(x);
        }
        int[] arr = new int[res.size()];
        Integer[] temp = res.toArray(new Integer[]{});
        for (int i = 0;i<temp.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
}

class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] columns = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int box_index = (i / 3 ) * 3 + j / 3;

                    if(rows[i].contains((int) num) || columns[j].contains((int) num) || boxes[box_index].contains((int) num))
                        return false;
                    else {
                        rows[i].add((int) num);
                        columns[j].add((int) num);
                        boxes[box_index].add((int) num);
                    }
                }
            }
        }
        return true;
    }
}

class Solution_316 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}

class Solution_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

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

class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}

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

class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        return set.size()!=nums.length;
    }
}

class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }
}

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

class Solution_62 {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}

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

class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}