package leetcode.weekly_contests.weekly_212;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1632 {

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        final Map<Integer, int[]> minRow = new HashMap<>();
        final Map<Integer, int[]> minCol = new HashMap<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] res = new int[n][m];
        final Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.computeIfAbsent(matrix[i][j], v -> new ArrayList<>()).add(new int[] { matrix[i][j], i, j });
            }
        }
        final List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.naturalOrder());
        for (int key : keys) {
            final List<int[]> v = map.get(key);
            final UnionFind uf = new UnionFind(v.size());
            final Map<Integer, List<Integer>> rows = new HashMap<>();
            final Map<Integer, List<Integer>> cols = new HashMap<>();
            for (int i = 0; i < v.size(); i++) {
                final int x = v.get(i)[1];
                final int y = v.get(i)[2];
                rows.computeIfAbsent(x, val -> new ArrayList<>()).add(i);
                cols.computeIfAbsent(y, val -> new ArrayList<>()).add(i);
            }
            for (List<Integer> row : rows.values()) {
                for (int i = 1; i < row.size(); i++) {
                    uf.union(row.get(i - 1), row.get(i));
                }
            }
            for (List<Integer> col : cols.values()) {
                for (int i = 1; i < col.size(); i++) {
                    uf.union(col.get(i - 1), col.get(i));
                }
            }
            final Map<Integer, Integer> maxPerComponent = new HashMap<>();
            for (int i = 0; i < v.size(); i++) {
                final int par = uf.find(i);
                maxPerComponent.merge(par, f(v.get(i), minRow, minCol, matrix), Math::max);
            }
            for (int i = 0; i < v.size(); i++) {
                final int[] curr = v.get(i);
                final int rank = maxPerComponent.get(uf.find(i));
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
            final int increase = matrix[minRow.get(x)[1]][minRow.get(x)[2]] != val ? 0 : 1;
            rank = Math.max(rank, minRow.get(x)[0] + increase);
        }
        if (minCol.containsKey(y)) {
            final int increase = matrix[minCol.get(y)[1]][minCol.get(y)[2]] != val ? 0 : 1;
            rank = Math.max(rank, minCol.get(y)[0] + increase);
        }
        if (rank == (int) -2e9) {
            rank = 1;
        }
        return rank;
    }
}
