package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int idx, List<Integer> curr,
                            List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            curr.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
