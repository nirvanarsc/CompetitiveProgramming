package leetcode.weekly_contests.weekly_249;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int colorTheGrid(int m, int n) {
        if (m == 1) {
            final int[][] dp = new int[n + 1][4];
            return dfs(n, 0, dp);
        }
        if (m == 2) {
            final int[][][] dp = new int[n + 1][4][4];
            return dfs(n, 0, 0, dp);
        }
        if (m == 3) {
            final int[][][][] dp = new int[n + 1][4][4][4];
            return dfs(n, 0, 0, 0, dp);
        }
        if (m == 4) {
            final int[][][][][] dp = new int[n + 1][4][4][4][4];
            return dfs(n, 0, 0, 0, 0, dp);
        }
        final int[][][][][][] dp = new int[n + 1][4][4][4][4][4];
        return dfs(n, 0, 0, 0, 0, 0, dp);
    }

    int dfs(int n, int a0, int[][] dp) {
        if (n == 0) { return 1; }
        if (dp[n][a0] != 0) {
            return dp[n][a0];
        }
        int ans = 0;
        final int[] colors = { 1, 2, 3 };
        for (int a : colors) {
            if (a == a0) {
                continue;
            }
            ans += dfs(n - 1, a, dp);
            ans %= MOD;
        }
        return dp[n][a0] = ans;
    }

    int dfs(int n, int a0, int b0, int[][][] dp) {
        if (n == 0) { return 1; }
        if (dp[n][a0][b0] != 0) {
            return dp[n][a0][b0];
        }
        int ans = 0;
        final int[] colors = { 1, 2, 3 };
        for (int a : colors) {
            if (a == a0) {
                continue;
            }
            for (int b : colors) {
                if (b == b0 || b == a) {
                    continue;
                }
                ans += dfs(n - 1, a, b, dp);
                ans %= MOD;
            }
        }
        return dp[n][a0][b0] = ans;
    }

    int dfs(int n, int a0, int b0, int c0, int[][][][] dp) {
        if (n == 0) { return 1; }
        if (dp[n][a0][b0][c0] != 0) {
            return dp[n][a0][b0][c0];
        }
        int ans = 0;
        final int[] colors = { 1, 2, 3 };
        for (int a : colors) {
            if (a == a0) {
                continue;
            }
            for (int b : colors) {
                if (b == b0 || b == a) {
                    continue;
                }
                for (int c : colors) {
                    if (c == c0 || c == b) {
                        continue;
                    }
                    ans += dfs(n - 1, a, b, c, dp);
                    ans %= MOD;
                }
            }
        }
        return dp[n][a0][b0][c0] = ans;
    }

    int dfs(int n, int a0, int b0, int c0, int d0, int[][][][][] dp) {
        if (n == 0) { return 1; }
        if (dp[n][a0][b0][c0][d0] != 0) {
            return dp[n][a0][b0][c0][d0];
        }
        int ans = 0;
        final int[] colors = { 1, 2, 3 };
        for (int a : colors) {
            if (a == a0) {
                continue;
            }
            for (int b : colors) {
                if (b == b0 || b == a) {
                    continue;
                }
                for (int c : colors) {
                    if (c == c0 || c == b) {
                        continue;
                    }
                    for (int d : colors) {
                        if (d == d0 || d == c) {
                            continue;
                        }
                        ans += dfs(n - 1, a, b, c, d, dp);
                        ans %= MOD;
                    }
                }
            }
        }
        return dp[n][a0][b0][c0][d0] = ans;
    }

    int dfs(int n, int a0, int b0, int c0, int d0, int e0, int[][][][][][] dp) {
        if (n == 0) { return 1; }
        if (dp[n][a0][b0][c0][d0][e0] != 0) {
            return dp[n][a0][b0][c0][d0][e0];
        }
        int ans = 0;
        final int[] colors = { 1, 2, 3 };
        for (int a : colors) {
            if (a == a0) {
                continue;
            }
            for (int b : colors) {
                if (b == b0 || b == a) {
                    continue;
                }
                for (int c : colors) {
                    if (c == c0 || c == b) {
                        continue;
                    }
                    for (int d : colors) {
                        if (d == d0 || d == c) {
                            continue;
                        }
                        for (int e : colors) {
                            if (e == e0 || e == d) {
                                continue;
                            }
                            ans += dfs(n - 1, a, b, c, d, e, dp);
                            ans %= MOD;
                        }
                    }
                }
            }
        }
        return dp[n][a0][b0][c0][d0][e0] = ans;
    }
}
