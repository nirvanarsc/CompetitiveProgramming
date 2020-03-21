package weekly_contests.weekly_90;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_856 {

    public int scoreOfParentheses(String S) {
        int res = 0, open = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') { open++; } else { open--; }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                res += 1 << open;
            }
        }
        return res;
    }

    public int scoreOfParenthesesStack(String S) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.addFirst(cur);
                cur = 0;
            } else {
                cur = stack.removeFirst() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}
