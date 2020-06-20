package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_351 {

    static class Pair {
        int[][] board;
        int i;
        int j;

        Pair(int[][] board, int i, int j) {
            this.board = board;
            this.i = i;
            this.j = j;
        }
    }

    private static final int[][] DIRS = {
            { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };

    private static final Map<String, int[][]> SKIPS = new HashMap<>();

    static {
        SKIPS.put("0,0", new int[][] { { 1, 2 }, { 2, 1 } });
        SKIPS.put("0,1", new int[][] { { 2, 0 }, { 2, 2 } });
        SKIPS.put("0,2", new int[][] { { 1, 0 }, { 2, 1 } });
        SKIPS.put("1,0", new int[][] { { 0, 2 }, { 2, 2 } });
        //noinspection ZeroLengthArrayAllocation
        SKIPS.put("1,1", new int[][] {});
        SKIPS.put("1,2", new int[][] { { 0, 0 }, { 2, 0 } });
        SKIPS.put("2,0", new int[][] { { 0, 1 }, { 1, 2 } });
        SKIPS.put("2,1", new int[][] { { 0, 0 }, { 0, 2 } });
        SKIPS.put("2,2", new int[][] { { 0, 1 }, { 1, 0 } });
    }

    public int numberOfPatternsBFS(int m, int n) {
        int[][] board = new int[3][3];
        int res = 0;
        board[0][0] = 1;
        res += 4 * bfs(m, n, board, 0, 0);
        board = new int[3][3];
        board[0][1] = 1;
        res += 4 * bfs(m, n, board, 0, 1);
        board = new int[3][3];
        board[1][1] = 1;
        res += bfs(m, n, board, 1, 1);
        return res;
    }

    private static int bfs(int m, int n, int[][] board, int row, int col) {
        final Deque<Pair> q = new ArrayDeque<>(Collections.singleton(new Pair(board, row, col)));
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= m) {
                res += q.size();
            }
            for (int level = q.size(); level > 0; level--) {
                final Pair currPair = q.removeFirst();
                final int[][] curr = currPair.board;
                for (int[] dir : DIRS) {
                    boolean inBounds = true;
                    int nr = currPair.i;
                    int nc = currPair.j;
                    while (inBounds) {
                        nr += dir[0];
                        nc += dir[1];
                        if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                            if (curr[nr][nc] == 0) {
                                final int[][] next = Arrays.stream(curr)
                                                           .map(int[]::clone)
                                                           .toArray(int[][]::new);
                                next[nr][nc] = 1;
                                q.offerLast(new Pair(next, nr, nc));
                                break;
                            }
                        } else {
                            inBounds = false;
                        }
                    }
                }
                for (int[] jump : SKIPS.get(currPair.i + "," + currPair.j)) {
                    final int nr = jump[0];
                    final int nc = jump[1];
                    if (curr[nr][nc] == 0) {
                        final int[][] next = Arrays.stream(curr)
                                                   .map(int[]::clone)
                                                   .toArray(int[][]::new);
                        next[nr][nc] = 1;
                        q.offerLast(new Pair(next, nr, nc));
                    }
                }
            }
        }
        return res;
    }

    public int numberOfPatterns(int m, int n) {
        final int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] =
        skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        final boolean[] visited = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(visited, skip, 1, i - 1) * 4;
            res += dfs(visited, skip, 2, i - 1) * 4;
            res += dfs(visited, skip, 5, i - 1);
        }
        return res;
    }

    private static int dfs(boolean[] visited, int[][] skip, int cur, int remain) {
        if (remain <= 0) {
            return remain == 0 ? 1 : 0;
        }
        visited[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[i][cur] == 0 || visited[skip[i][cur]])) {
                res += dfs(visited, skip, i, remain - 1);
            }
        }
        visited[cur] = false;
        return res;
    }
}
