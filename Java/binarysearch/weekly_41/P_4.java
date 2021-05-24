package binarysearch.weekly_41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_4 {

    public int solve(int[][] lines, int lo, int hi) {
        final int n = lines.length;
        final long[][] p = new long[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = (long) lines[i][0] * lo + lines[i][1];
            p[i][1] = (long) lines[i][0] * hi + lines[i][1];
        }
        Arrays.sort(p, (a, b) -> a[0] == b[0] ? Long.compare(b[1], a[1]) : Long.compare(a[0], b[0]));
        long max = p[0][1];
        long min = p[n - 1][1];
        final Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (p[i][1] <= max) {
                set.add(i);
            }
            max = Math.max(max, p[i][1]);
        }
        for (int i = n - 2; i > -1; i--) {
            if (p[i][1] >= min) {
                set.add(i);
            }
            min = Math.min(min, p[i][1]);
        }
        return set.size();
    }
}
