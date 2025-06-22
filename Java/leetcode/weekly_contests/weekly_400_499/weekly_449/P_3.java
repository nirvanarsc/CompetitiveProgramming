package leetcode.weekly_contests.weekly_400_499.weekly_449;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public boolean canPartitionGrid(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        long totalSum = 0;
        final long[] rowSums = new long[m];
        final long[] colSums = new long[n];
        final Map<Integer, List<int[]>> locations = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int val = grid[i][j];
                totalSum += val;
                rowSums[i] += val;
                colSums[j] += val;
                locations.computeIfAbsent(val, k -> new ArrayList<>()).add(new int[] { i, j });
            }
        }
        long currentSumA = 0;
        for (int i = 0; i < m - 1; i++) {
            currentSumA += rowSums[i];
            final long currentSumB = totalSum - currentSumA;
            if (currentSumA == currentSumB) {
                return true;
            }
            final long diff = Math.abs(currentSumA - currentSumB);
            if (diff <= (int) 1e5) {
                final int targetVal = (int) diff;
                if (locations.containsKey(targetVal)) {
                    if (currentSumA > currentSumB) {
                        if (check(locations.get(targetVal), 0, i, 0, n - 1)) {
                            return true;
                        }
                    } else {
                        if (check(locations.get(targetVal), i + 1, m - 1, 0, n - 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        currentSumA = 0;
        for (int j = 0; j < n - 1; j++) {
            currentSumA += colSums[j];
            final long currentSumB = totalSum - currentSumA;
            if (currentSumA == currentSumB) {
                return true;
            }
            final long diff = Math.abs(currentSumA - currentSumB);
            if (diff <= (int) 1e5) {
                final int targetVal = (int) diff;
                if (locations.containsKey(targetVal)) {
                    if (currentSumA > currentSumB) {
                        if (check(locations.get(targetVal), 0, m - 1, 0, j)) {
                            return true;
                        }
                    } else {
                        if (check(locations.get(targetVal), 0, m - 1, j + 1, n - 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean check(List<int[]> candidates, int r1, int r2, int c1, int c2) {
        final int numRowsInSection = r2 - r1 + 1;
        final int numColsInSection = c2 - c1 + 1;
        for (int[] pos : candidates) {
            final int r = pos[0];
            final int c = pos[1];
            if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
                if (numRowsInSection > 1 && numColsInSection > 1) {
                    return true;
                } else if (numRowsInSection == 1) {
                    if (numColsInSection <= 2 || c == c1 || c == c2) {
                        return true;
                    }
                } else if (numColsInSection == 1) {
                    if (numRowsInSection <= 2 || r == r1 || r == r2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
