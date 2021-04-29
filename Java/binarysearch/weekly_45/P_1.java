package binarysearch.weekly_45;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P_1 {

    public int[] solve(int[][] relations) {
        final Set<Long> set = new HashSet<>();
        final long n = (long) 1e5;
        for (int[] e : relations) {
            set.add(n * e[0] + e[1]);
        }
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int[] e : relations) {
            if (set.contains(n * e[1] + e[0])) {
                ts.add(e[0]);
                ts.add(e[1]);
            }
        }
        final int[] res = new int[ts.size()];
        int idx = 0;
        for (int v : ts) {
            res[idx++] = v;
        }
        return res;
    }
}
