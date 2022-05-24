package leetcode.weekly_contests.weekly_0_99.weekly_34;

public class P_600 {

    public int findIntegersTopDown(int num) {
        final int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int i = 30, sum = 0, prev = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prev == 1) {
                    sum--;
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            i--;
        }
        return sum + 1;
    }

    static boolean[][][] seen;
    static int[][][] dp;

    public int findIntegers(int n) {
        seen = new boolean[32][2][2];
        dp = new int[32][2][2];
        return dfs(n, 31, 0, 0);
    }

    private static int dfs(int n, int idx, int prev, int smaller) {
        if (idx < 0) {
            return 1;
        }
        if (seen[idx][prev][smaller]) {
            return dp[idx][prev][smaller];
        }
        int res = 0;
        if (smaller == 1) {
            if (prev == 0) {
                res += dfs(n, idx - 1, 1, 1);
            }
            res += dfs(n, idx - 1, 0, 1);
        } else {
            if (prev == 0 && (n & (1 << idx)) != 0) {
                res += dfs(n, idx - 1, 1, 0);
            }
            if ((n & (1 << idx)) != 0) {
                res += dfs(n, idx - 1, 0, 1);
            } else {
                res += dfs(n, idx - 1, 0, 0);
            }
        }
        seen[idx][prev][smaller] = true;
        return dp[idx][prev][smaller] = res;
    }
}
