package leetcode.weekly_contests.weekly_212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class P_1632 {

    public int[][] matrixRankTransform(int[][] matrix) {
        final Map<Integer, int[]> minRow = new HashMap<>();
        final Map<Integer, int[]> minCol = new HashMap<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] res = new int[n][m];
        final TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tm.computeIfAbsent(matrix[i][j], v -> new ArrayList<>()).add(new int[] { matrix[i][j], i, j });
            }
        }
        for (List<int[]> v : tm.values()) {
            final PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(f(b, minRow, minCol, matrix), f(a, minRow, minCol, matrix)));
            pq.addAll(v);
            while (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                final int rank = f(curr, minRow, minCol, matrix);
                final int x = curr[1];
                final int y = curr[2];
                res[x][y] = rank;
                minRow.put(x, new int[] { rank, x, y });
                minCol.put(y, new int[] { rank, x, y });
            }
            pq.addAll(v);
            while (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                final int rank = f(curr, minRow, minCol, matrix);
                final int x = curr[1];
                final int y = curr[2];
                res[x][y] = rank;
                minRow.put(x, new int[] { rank, x, y });
                minCol.put(y, new int[] { rank, x, y });
            }
        }
        return res;
    }

    private static int f(int[] item, Map<Integer, int[]> minRow, Map<Integer, int[]> minCol, int[][] matrix) {
        final int val = item[0];
        final int x = item[1];
        final int y = item[2];
        int rank = (int) -2e9;
        if (minRow.containsKey(x)) {
            if (matrix[minRow.get(x)[1]][minRow.get(x)[2]] == val) {
                rank = Math.max(rank, minRow.get(x)[0]);
            } else {
                rank = Math.max(rank, minRow.get(x)[0] + 1);
            }
        }
        if (minCol.containsKey(y)) {
            if (matrix[minCol.get(y)[1]][minCol.get(y)[2]] == val) {
                rank = Math.max(rank, minCol.get(y)[0]);
            } else {
                rank = Math.max(rank, minCol.get(y)[0] + 1);
            }
        }
        if (rank == (int) -2e9) {
            rank = 1;
        }
        return rank;
    }
}
