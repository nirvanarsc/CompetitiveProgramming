package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_22 {

    public static List<String> generateParenthesis(int n) {
        final List<String> res = new ArrayList<>();
        dfs(0, 0, n, "", res);
        return res;
    }

    private static void dfs(int open, int close, int n, String curr, List<String> res) {
        if (open + close == 2 * n) {
            res.add(curr);
            return;
        }

        if (open < n) {
            dfs(open + 1, close, n, curr + '(', res);
        }

        if (close < open) {
            dfs(open, close + 1, n, curr + ')', res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private P_22() {}
}
