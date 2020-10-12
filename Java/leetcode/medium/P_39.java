package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private static void dfs(int[] cand, int target, int idx, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = idx; i < cand.length && target >= cand[idx]; i++) {
            curr.add(cand[i]);
            dfs(cand, target - cand[i], i, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
