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

    public List<String> generateParenthesisCatalan(int n) {
        return dfs(1, n);
    }

    public List<String> dfs(int start, int end) {
        final List<String> res = new ArrayList<>();
        if (start > end) {
            res.add("");
            return res;
        }
        for (int i = start; i <= end; i++) {
            final List<String> leftNodes = dfs(start, i - 1);
            final List<String> rightNodes = dfs(i + 1, end);
            for (String left : leftNodes) {
                for (String right : rightNodes) {
                    res.add('(' + left + ')' + right);
                }
            }
        }
        return res;
    }
}
