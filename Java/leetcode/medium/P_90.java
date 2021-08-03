package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDupSet(int[] nums) {
        final Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
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
        return new ArrayList<>(res);
    }
}
