package leetcode.weekly_contests.weekly_300_399.weekly_340;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class P_4 {

    public int minimumVisitedCells(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final TreeSet<Integer>[] s0 = new TreeSet[n];
        final TreeSet<Integer>[] s1 = new TreeSet[m];
        for (int i = 0; i < n; i++) {
            s0[i] = new TreeSet<>();
            for (int j = 0; j < m; j++) {
                s0[i].add(j);
            }
        }
        for (int j = 0; j < m; j++) {
            s1[j] = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                s1[j].add(i);
            }
        }
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0, 1 });
        while (!dq.isEmpty()) {
            final int[] cell = dq.removeFirst();
            final int i = cell[0];
            final int j = cell[1];
            final int d = cell[2];
            if (i == n - 1 && j == m - 1) {
                return d;
            }
            Integer k = s0[i].ceiling(j + 1);
            while (k != null && k <= j + grid[i][j]) {
                dq.offer(new int[] { i, k, d + 1 });
                s0[i].remove(k);
                s1[k].remove(i);
                k = s0[i].ceiling(j + 1);
            }
            k = s1[j].ceiling(i + 1);
            while (k != null && k <= i + grid[i][j]) {
                dq.offer(new int[] { k, j, d + 1 });
                s1[j].remove(k);
                s0[k].remove(j);
                k = s1[j].ceiling(i + 1);
            }
        }
        return -1;
    }
}
