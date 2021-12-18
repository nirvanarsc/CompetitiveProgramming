package leetcode.weekly_contests.weekly_101;

public class P_902 {

    static int[][] dp;
    static boolean[][] seen;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        final int m = digits.length;
        final int[] l = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = digits[i].charAt(0) - '0';
        }
        int L = 0;
        int copy = n;
        while (copy > 0) {
            L++;
            copy /= 10;
        }
        final int[] r = new int[L];
        for (int i = L - 1; i >= 0; i--) {
            r[i] = n % 10;
            n /= 10;
        }
        int res = 0;
        int p = m;
        for (int i = 0; i < (L - 1); i++) {
            res += p;
            p *= m;
        }
        dp = new int[L][2];
        seen = new boolean[L][2];
        return res + dfs(l, r, 0, 0);
    }

    private static int dfs(int[] l, int[] r, int idx, int smaller) {
        if (idx == r.length) {
            return 1;
        }
        if (seen[idx][smaller]) {
            return dp[idx][smaller];
        }
        int res = 0;
        if (smaller == 1) {
            res += l.length * dfs(l, r, idx + 1, 1);
        } else {
            for (int num : l) {
                if (r[idx] == num) {
                    res += dfs(l, r, idx + 1, 0);
                } else if (r[idx] > num) {
                    res += dfs(l, r, idx + 1, 1);
                }
            }
        }
        seen[idx][smaller] = true;
        return dp[idx][smaller] = res;
    }
}
