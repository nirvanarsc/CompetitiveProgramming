package medium;

import java.util.HashMap;
import java.util.Map;

public class P_935 {
    private static final int[][] DIRS =
            { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };
    private static final int[][] BOARD = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
    private static final int MOD = (int) (1e9 + 7);

    public int knightDialer(int n) {
        long res = 0;
        final Map<String, Long> dp = new HashMap<>();
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[0].length; j++) {
                if (BOARD[i][j] != -1) {
                    res += recurse(i, j, n, dp);
                    res %= MOD;
                }
            }
        }
        return (int) res;
    }

    private static long recurse(int i, int j, int n, Map<String, Long> dp) {
        if (i < 0 || i >= BOARD.length || j < 0 || j >= BOARD[0].length || BOARD[i][j] == -1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        final String key = i + "," + j + ',' + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        long res = 0;
        for (int[] dir : DIRS) {
            res += recurse(i + dir[0], j + dir[1], n - 1, dp);
            res %= MOD;
        }
        dp.put(key, res);
        return res;
    }

    public int knightDialerG(int n) {
        final int[][] graph = {
                { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 },
                { 2, 4 }
        };
        int cnt = 0;
        final Integer[][] memo = new Integer[n + 1][10];
        for (int i = 0; i < graph.length; i++) {
            cnt += helper(n - 1, i, graph, memo);
            cnt %= MOD;
        }
        return cnt;
    }

    private static int helper(int n, int cur, int[][] graph, Integer[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][cur] != null) {
            return memo[n][cur];
        }
        int cnt = 0;
        for (int neighbour : graph[cur]) {
            cnt += helper(n - 1, neighbour, graph, memo);
            cnt %= MOD;
        }
        return memo[n][cur] = cnt;
    }
}
