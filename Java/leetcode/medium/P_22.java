package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public final class P_22 {

    public List<String> generateParenthesis(int n) {
        final List<String> res = new ArrayList<>();
        dfs(res, n, n, new StringBuilder());
        return res;
    }

    private static void dfs(List<String> res, int open, int close, StringBuilder curr) {
        if (open == 0 && close == 0) {
            res.add(curr.toString());
            return;
        }
        if (close > open) {
            curr.append(')');
            dfs(res, open, close - 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open > 0) {
            curr.append('(');
            dfs(res, open - 1, close, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
