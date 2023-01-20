package leetcode.weekly_contests.weekly_0_99.weekly_16a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final Set<String> seen = new HashSet<>();
        final int n = nums.length;
        for (int mask = 0; mask < 1 << n; mask++) {
            if ((mask & (mask - 1)) == 0) {
                continue;
            }
            final List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr.add(nums[i]);
                }
            }
            if (f(curr)) {
                if (seen.add(hash(curr))) {
                    res.add(curr);
                }
            }
        }
        return res;
    }

    private static boolean f(List<Integer> curr) {
        for (int i = 0; i < curr.size() - 1; i++) {
            if (curr.get(i) > curr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static String hash(List<Integer> curr) {
        final StringBuilder sb = new StringBuilder();
        for (int u : curr) {
            sb.append(u).append(',');
        }
        return sb.toString();
    }
}
