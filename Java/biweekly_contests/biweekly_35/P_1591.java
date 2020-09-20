package biweekly_contests.biweekly_35;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1591 {

    public boolean isPrintable(int[][] targetGrid) {
        final int n = targetGrid.length;
        final int m = targetGrid[0].length;
        final int[] degree = new int[61];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int color = 1; color <= 60; color++) {
            int maxX = 0, minX = 60, maxY = 0, minY = 60;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (targetGrid[i][j] == color) {
                        maxX = Math.max(maxX, i);
                        minX = Math.min(minX, i);
                        maxY = Math.max(maxY, j);
                        minY = Math.min(minY, j);
                    }
                }
            }
            for (int i = minX; i <= maxX; i++) {
                for (int j = minY; j <= maxY; j++) {
                    if (targetGrid[i][j] != color) {
                        g.computeIfAbsent(color, v -> new ArrayList<>()).add(targetGrid[i][j]);
                        degree[targetGrid[i][j]]++;
                    }
                }
            }
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 60; i++) {
            if (degree[i] == 0) {
                q.offerLast(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            cnt++;
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--degree[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return cnt == 60;
    }
}
