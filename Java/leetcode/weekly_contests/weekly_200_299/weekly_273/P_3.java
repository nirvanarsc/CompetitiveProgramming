package leetcode.weekly_contests.weekly_200_299.weekly_273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public long[] getDistances(int[] arr) {
        final int n = arr.length;
        final long[] res = new long[n];
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], val -> new ArrayList<>()).add(i);
        }
        for (List<Integer> idx : map.values()) {
            long curr = 0;
            final int s = idx.get(0);
            final int m = idx.size();
            for (int i = 1; i < m; i++) {
                curr += idx.get(i) - s;
            }
            res[s] = curr;
            int ll = 0;
            int rr = m - 1;
            int prev = s;
            for (int i = 1; i < m; i++) {
                final int currIdx = idx.get(i);
                final int d = currIdx - prev;
                curr += ll++ * d;
                curr -= --rr * d;
                res[currIdx] = curr;
                prev = currIdx;
            }
        }
        return res;
    }
}
