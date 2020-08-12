package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int idx, List<Integer> curr,
                            List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (target < candidates[i]) { break; }
            if (i > idx && candidates[i - 1] == candidates[i]) { continue; }
            curr.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
