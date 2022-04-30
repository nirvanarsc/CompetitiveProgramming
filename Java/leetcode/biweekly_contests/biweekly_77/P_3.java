package leetcode.biweekly_contests.biweekly_77;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_3 {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        final int[][] g = new int[m][n];
        final Map<Integer, TreeSet<int[]>> row = new HashMap<>();
        final Map<Integer, TreeSet<int[]>> col = new HashMap<>();
        for (int[] c : guards) {
            g[c[0]][c[1]] = 1;
            row.computeIfAbsent(c[0], val -> new TreeSet<>(Comparator.comparingInt(a -> a[0])))
               .add(new int[] { c[1], 1 });
            col.computeIfAbsent(c[1], val -> new TreeSet<>(Comparator.comparingInt(a -> a[0])))
               .add(new int[] { c[0], 1 });
        }
        for (int[] w : walls) {
            g[w[0]][w[1]] = 2;
            row.computeIfAbsent(w[0], val -> new TreeSet<>(Comparator.comparingInt(a -> a[0])))
               .add(new int[] { w[1], 2 });
            col.computeIfAbsent(w[1], val -> new TreeSet<>(Comparator.comparingInt(a -> a[0])))
               .add(new int[] { w[0], 2 });
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    final TreeSet<int[]> r = row.getOrDefault(i, new TreeSet<>(Comparator.comparingInt(a -> a[0])));
                    final TreeSet<int[]> c = col.getOrDefault(j, new TreeSet<>(Comparator.comparingInt(a -> a[0])));
                    final int[] u = r.floor(new int[] { j, -1 });
                    final int[] d = r.ceiling(new int[] { j, -1 });
                    final int[] ll = c.floor(new int[] { i, -1 });
                    final int[] rr = c.ceiling(new int[] { i, -1 });
                    if (u != null && u[1] == 1) {
                        continue;
                    }
                    if (d != null && d[1] == 1) {
                        continue;
                    }
                    if (ll != null && ll[1] == 1) {
                        continue;
                    }
                    if (rr != null && rr[1] == 1) {
                        continue;
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
