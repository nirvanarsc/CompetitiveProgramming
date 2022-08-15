package leetcode.weekly_contests.weekly_300_399.weekly_306;

public class P_4 {

    static boolean[][][] seen1;
    static int[][][] dp1;
    static boolean[][] seen2;
    static int[][] dp2;

    public int countSpecialNumbers(int n) {
        long limit = 10;
        int l = 1;
        int res = 0;
        while (limit <= n) {
            seen2 = new boolean[l][1 << 10];
            dp2 = new int[l][1 << 10];
            res += dfs2(0, 0, l);
            limit *= 10;
            l++;
        }
        final char[] w = String.valueOf(n).toCharArray();
        seen1 = new boolean[w.length][1 << 10][2];
        dp1 = new int[w.length][1 << 10][2];
        res += dfs1(w, 0, 0, 0);
        return res;
    }

    private static int dfs1(char[] w, int idx, int mask, int smaller) {
        if (idx == w.length) {
            return 1;
        }
        if (seen1[idx][mask][smaller]) {
            return dp1[idx][mask][smaller];
        }
        int res = 0;
        if (smaller == 0) {
            for (int i = idx == 0 ? 1 : 0; i <= w[idx] - '0'; i++) {
                if ((mask & (1 << i)) == 0) {
                    res += dfs1(w, idx + 1, mask | 1 << i, i != w[idx] - '0' ? 1 : 0);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if ((mask & (1 << i)) == 0) {
                    res += dfs1(w, idx + 1, mask | 1 << i, 1);
                }
            }
        }
        seen1[idx][mask][smaller] = true;
        return dp1[idx][mask][smaller] = res;
    }

    private static int dfs2(int idx, int mask, int l) {
        if (idx == l) {
            return 1;
        }
        if (seen2[idx][mask]) {
            return dp2[idx][mask];
        }
        int res = 0;
        for (int i = idx == 0 ? 1 : 0; i < 10; i++) {
            if ((mask & (1 << i)) == 0) {
                res += dfs2(idx + 1, mask | 1 << i, l);
            }
        }
        seen2[idx][mask] = true;
        return dp2[idx][mask] = res;
    }
}
