package leetcode.biweekly_contests.biweekly_0_99.biweekly_78;

import java.util.Arrays;
import java.util.Comparator;

public class P_3 {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        final int n = tiles.length;
        final long[] pre = new long[n + 1];
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (tiles[i - 1][1] - tiles[i - 1][0] + 1);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            final int[] t = tiles[i];
            final int target = t[0] + carpetLen - 1;
            int u = lowerBound(tiles, target);
            if (u == n || tiles[u][0] > target) {
                u--;
            }
            final long full = pre[u] - pre[i];
            final long partial = Math.min(tiles[u][1], target) - tiles[u][0] + 1;
            res = Math.max(res, full + partial);
        }
        return (int) res;
    }

    private static int lowerBound(int[][] t, int target) {
        int lo = 0;
        int hi = t.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (t[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
