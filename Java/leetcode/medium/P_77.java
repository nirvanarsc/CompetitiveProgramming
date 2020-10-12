package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_77 {

    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public static void dfs(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            curr.add(i);
            dfs(i + 1, n, k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
