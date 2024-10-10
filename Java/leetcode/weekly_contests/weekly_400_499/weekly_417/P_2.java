package leetcode.weekly_contests.weekly_400_499.weekly_417;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int countOfSubstrings(String word, int k) {
        final char[] w = word.toCharArray();
        final int n = w.length;
        final int[][] pre = new int[n + 1][6];
        final Map<Integer, Integer> map = new HashMap<>();
        final int[] cc = new int[n];
        int c = 0;
        final String vowels = "aeiou";
        for (int i = 1; i <= n; i++) {
            cc[i - 1] = c;
            for (int j = 0; j < 6; j++) {
                pre[i][j] += pre[i - 1][j];
            }
            final int idx = vowels.indexOf(w[i - 1]);
            if (idx == -1) {
                map.put(++c, i - 1);
            } else {
                pre[i][idx]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            final int u = map.getOrDefault(cc[i] + k, -1);
            final int v = map.getOrDefault(cc[i] + k + 1, n);
            int lb = Math.max(u, lowerBound(pre, i));
            if (u == -1 && k != 0) {
                lb = v;
            }
            res += Math.max(0, v - lb);
        }
        return res;
    }

    private static int lowerBound(int[][] pre, int from) {
        int lo = from;
        int hi = pre.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            boolean ok = true;
            for (int i = 0; i < 5; i++) {
                ok &= pre[mid + 1][i] - pre[from][i] > 0;
            }
            if (!ok) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
