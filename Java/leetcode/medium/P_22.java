package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public final class P_22 {

    public List<String> generateParenthesis(int n) {
        final List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    private static void dfs(int open, int close, StringBuilder sb, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(new String(sb));
            return;
        }
        if (open > 0) {
            sb.append('(');
            dfs(open - 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open < close) {
            sb.append(')');
            dfs(open, close - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
