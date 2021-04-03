package leetcode.hard;

public class P_32 {

    public int longestValidParentheses(String s) {
        int res = 0;
        final int n = s.length();
        final int[] stack = new int[n + 1];
        int idx = 0;
        stack[idx++] = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack[idx++] = i;
            } else {
                idx--;
                if (idx == 0) {
                    stack[idx++] = i;
                } else {
                    res = Math.max(res, i - stack[idx - 1]);
                }
            }
        }
        return res;
    }
}
