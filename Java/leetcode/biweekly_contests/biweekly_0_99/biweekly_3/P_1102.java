package leetcode.biweekly_contests.biweekly_0_99.biweekly_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import utils.DataStructures.UnionFind;

public class P_1102 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maximumMinimumPath(int[][] A) {
        int res = Integer.MAX_VALUE;
        final int n = A.length;
        final int m = A[0].length;
        final int[] target = { n - 1, m - 1 };
        final boolean[][] visited = new boolean[n][m];
        final PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> Integer.compare(A[b[0]][b[1]], A[a[0]][a[1]]));
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                final int[] curr = q.remove();
                visited[curr[0]][curr[1]] = true;
                res = Math.min(res, A[curr[0]][curr[1]]);
                if (res == 0 || Arrays.equals(curr, target)) {
                    return res;
                }
                for (int[] dir : DIRS) {
                    final int nextX = curr[0] + dir[0];
                    final int nextY = curr[1] + dir[1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
                        q.add(new int[] { nextX, nextY });
                    }
                }
            }
        }
        return -1;
    }

    public int maximumMinimumPathUF(int[][] A) {
        final int n = A.length;
        final int m = A[0].length;
        final List<int[]> coords = new ArrayList<>();
        final boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                coords.add(new int[] { i, j });
            }
        }
        coords.sort((a, b) -> Integer.compare(A[b[0]][b[1]], A[a[0]][a[1]]));
        final UnionFind uf = new UnionFind(n * m);
        for (int[] coord : coords) {
            final int x = coord[0];
            final int y = coord[1];
            visited[x][y] = true;
            for (int[] dir: DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny]) {
                    uf.union(x * m + y, nx * m + ny);
                }
            }
            if (uf.find(0) == uf.find((n - 1) * m + m - 1)) {
                return A[x][y];
            }
        }
        return -1;
    }
}
