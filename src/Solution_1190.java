import java.util.Stack;

class Solution_1190 {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else if (ch[i] == ')') {
                reverse(ch, stack.pop() + 1, i - 1);
            }
        }
        for (char c : ch) {
            if (c != '(' && c != ')') {
                res.append(c);
            }
        }
        return res.toString();
    }

    private void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }
}
