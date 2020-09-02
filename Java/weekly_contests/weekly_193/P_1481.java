package weekly_contests.weekly_193;

import java.util.HashMap;
import java.util.Map;

public class P_1481 {

    private static int[][] lookup;

    private static void buildSparseTable(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            lookup[i][0] = arr[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; (i + (1 << j) - 1) < n; i++) {
                lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    private static int query(int l, int r) {
        final int height = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.max(lookup[l][height], lookup[r - (1 << height) + 1][height]);
    }

    // TLE
    public int minDaysDP(int[] bloomDay, int m, int k) {
        final int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }
        lookup = new int[n + 1][(int) (Math.log(n) / Math.log(2)) + 1];
        buildSparseTable(bloomDay, n);
        final int dfs = dfs(bloomDay, m, k, -1, 0, new HashMap<>());
        return dfs == Integer.MAX_VALUE ? -1 : dfs;
    }

    private static int dfs(int[] bloomDay, int m, int k, int currMax, int idx, Map<String, Integer> dp) {
        if (idx >= bloomDay.length) {
            return m == 0 ? currMax : Integer.MAX_VALUE;
        }
        final String key = idx + "," + currMax;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int pick = Integer.MAX_VALUE;
        if (m > 0 && idx + k <= bloomDay.length) {
            final int nextMax = Math.max(currMax, query(idx, idx + k - 1));
            pick = dfs(bloomDay, m - 1, k, nextMax, idx + k, dp);
        }
        final int skip = dfs(bloomDay, m, k, currMax, idx + 1, dp);
        dp.put(key, Math.min(pick, skip));
        return Math.min(pick, skip);
    }

    public int minDays(int[] arr, int m, int k) {
        if ((long) m * k > arr.length) {
            return -1;
        }
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            int curr = 0, bouq = 0;
            for (int flower : arr) {
                if (flower > mid) {
                    curr = 0;
                } else if (++curr >= k) {
                    bouq++;
                    curr = 0;
                }
            }
            if (bouq < m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
