package leetcode.weekly_contests.weekly_0_99.weekly_90;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_856 {

    public int scoreOfParentheses(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int res = 0;
        int open = 0;
        for (int i = 0; i < n; i++) {
            open += w[i] == '(' ? 1 : -1;
            if (w[i] == ')' && w[i - 1] == '(') {
                res += 1 << open;
            }
        }
        return res;
    }

    public int scoreOfParenthesesStack(String s) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addFirst(cur);
                cur = 0;
            } else {
                cur = stack.removeFirst() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

    public int scoreOfParenthesesDFS(String s) {
        return dfs(s.toCharArray(), 0, s.length() - 1);
    }

    private static int dfs(char[] s, int from, int to) {
        if (from >= to) {
            return 0;
        }
        if (to - from == 1) {
            return 1;
        }
        int open = 0;
        int mid = from;
        for (int i = from; i <= to; i++) {
            open += s[i] == '(' ? 1 : -1;
            mid++;
            if (open == 0) {
                break;
            }
        }
        if (mid - from == 2) {
            return 1 + dfs(s, mid, to);
        }
        return 2 * dfs(s, from + 1, mid - 2) + dfs(s, mid, to);
    }
}
