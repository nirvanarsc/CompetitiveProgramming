package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public final class P_78 {

    public static List<List<Integer>> subsetsBitwise(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final int n = nums.length;
        for (int mask = 0; mask < 1 << n; mask++) {
            final List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr.add(nums[i]);
                }
            }
            res.add(curr);
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            dfs(nums, j + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
