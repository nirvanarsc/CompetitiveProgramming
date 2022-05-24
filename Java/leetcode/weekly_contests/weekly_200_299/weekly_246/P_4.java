package leetcode.weekly_contests.weekly_200_299.weekly_246;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    public int[] minDifference(int[] nums, int[][] queries) {
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            g.add(new ArrayList<>());
        }
        final int n = nums.length;
        final int q = queries.length;
        for (int i = 0; i < n; i++) {
            g.get(nums[i] - 1).add(i);
        }
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int l = queries[i][0];
            final int r = queries[i][1];
            final List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                final int idx = lowerBound(g.get(j), l);
                if (idx < g.get(j).size()) {
                    final int p = g.get(j).get(idx);
                    if (l <= p && p <= r) {
                        curr.add(j);
                    }
                }
            }
            int best = 200;
            for (int j = 0; j < curr.size() - 1; j++) {
                best = Math.min(best, curr.get(j + 1) - curr.get(j));
            }
            res[i] = best == 200 ? -1 : best;
        }
        return res;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
