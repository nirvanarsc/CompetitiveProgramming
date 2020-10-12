package leetcode.weekly_contests.weekly_16a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() > 1) {
            res.add(new ArrayList<>(curr));
        }
        final Set<Integer> seen = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (seen.add(nums[j])) {
                if (curr.isEmpty() || curr.get(curr.size() - 1) <= nums[j]) {
                    curr.add(nums[j]);
                    dfs(nums, j + 1, res, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
