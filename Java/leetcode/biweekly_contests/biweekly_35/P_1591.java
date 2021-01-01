package leetcode.biweekly_contests.biweekly_35;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1591 {

    public boolean isPrintable(int[][] targetGrid) {
        final int[] minRow = new int[60];
        final int[] minCol = new int[60];
        Arrays.fill(minRow, (int) 1e9);
        Arrays.fill(minCol, (int) 1e9);
        final int[] maxRow = new int[60];
        final int[] maxCol = new int[60];
        final int n = targetGrid.length;
        final int m = targetGrid[0].length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int color = targetGrid[i][j] - 1;
                total |= 1L << color;
                minRow[color] = Math.min(minRow[color], i);
                minCol[color] = Math.min(minCol[color], j);
                maxRow[color] = Math.max(maxRow[color], i);
                maxCol[color] = Math.max(maxCol[color], j);
            }
        }
        final int[] inDeg = new int[60];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int color = 0; color < 60; color++) {
            for (int i = minRow[color]; i <= maxRow[color]; i++) {
                for (int j = minCol[color]; j <= maxCol[color]; j++) {
                    final int other = targetGrid[i][j] - 1;
                    if (other != color) {
                        g.computeIfAbsent(color, val -> new ArrayList<>()).add(other);
                        inDeg[other]++;
                    }
                }
            }
        }
        int target = Long.bitCount(total);
        final Deque<Integer> q = new ArrayDeque<>();
        for (int color = 0; color < 60; color++) {
            if ((total & (1L << color)) != 0 && inDeg[color] == 0) {
                q.offerLast(color);
            }
        }
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            target--;
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDeg[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return target == 0;
    }
}
