package medium;

import java.util.ArrayList;
import java.util.List;

public class P_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> res = new ArrayList<>();
        final int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        dfs(nums, 0, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] nums, int idx, int target, int k, List<Integer> curr,
                            List<List<Integer>> res) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = idx; i < nums.length && nums[i] <= target; i++) {
            curr.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
