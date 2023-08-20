package leetcode.weekly_contests.weekly_300_399.weekly_359;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        final Map<Integer, List<int[]>> g = new HashMap<>();
        final int n = nums.size();
        for (int i = 0; i < n; i++) {
            final List<int[]> e = g.computeIfAbsent(nums.get(i), val -> new ArrayList<>());
            e.add(new int[] { i, e.size() });
        }
        int res = 0;
        for (List<int[]> l : g.values()) {
            for (int[] curr : l) {
                res = Math.max(res, l.get(upperBound(l, curr, k))[1] - curr[1] + 1);
            }
        }
        return res;
    }

    private static int upperBound(List<int[]> list, int[] target, int k) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            final int[] curr = list.get(mid);
            final int total = curr[0] - target[0] + 1;
            final int same = curr[1] - target[1] + 1;
            final int diff = total - same;
            if (diff > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
