package medium;

import java.util.ArrayList;
import java.util.List;

public class P_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int start, int target, int k, List<Integer> curr, List<List<Integer>> res) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
        }
        for (int i = start; i < 10; i++) {
            if (target < i) { break; }
            curr.add(i);
            dfs(i + 1, target - i, k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
