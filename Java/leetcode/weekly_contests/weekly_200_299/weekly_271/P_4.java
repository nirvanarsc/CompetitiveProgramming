package leetcode.weekly_contests.weekly_200_299.weekly_271;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_4 {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        final List<int[]> ll = new ArrayList<>();
        final List<int[]> rr = new ArrayList<>();
        for (int[] fruit : fruits) {
            if (fruit[0] <= startPos) {
                ll.add(new int[] { startPos - fruit[0], fruit[1] });
            } else {
                rr.add(new int[] { fruit[0] - startPos, fruit[1] });
            }
        }
        Collections.reverse(ll);
        for (int i = 1; i < ll.size(); i++) {
            final int[] prev = ll.get(i - 1);
            final int[] curr = ll.get(i);
            ll.set(i, new int[] { curr[0], curr[1] + prev[1] });
        }
        for (int i = 1; i < rr.size(); i++) {
            final int[] prev = rr.get(i - 1);
            final int[] curr = rr.get(i);
            rr.set(i, new int[] { curr[0], curr[1] + prev[1] });
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int l = upperBound(ll, i);
            int r = upperBound(rr, k - 2 * i);
            int curr = 0;
            if (l < ll.size() && ll.get(l)[0] <= i) {
                curr += ll.get(l)[1];
            }
            if (r < rr.size() && rr.get(r)[0] <= (k - 2 * i)) {
                curr += rr.get(r)[1];
            }
            res = Math.max(res, curr);
            r = upperBound(rr, i);
            l = upperBound(ll, k - 2 * i);
            curr = 0;
            if (r < rr.size() && rr.get(r)[0] <= i) {
                curr += rr.get(r)[1];
            }
            if (l < ll.size() && ll.get(l)[0] <= (k - 2 * i)) {
                curr += ll.get(l)[1];
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    private static int upperBound(List<int[]> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            final int mid = 1 + lo + hi >>> 1;
            if (list.get(mid)[0] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
