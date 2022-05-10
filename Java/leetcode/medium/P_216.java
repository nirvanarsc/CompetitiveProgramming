package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_216 {

    static List<List<Integer>> res;
    static List<Integer> curr;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        curr = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }

    private static void dfs(int idx, int target, int k) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int num = idx; num < 10 && num <= target; num++) {
            curr.add(num);
            dfs(num + 1, target - num, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
}
