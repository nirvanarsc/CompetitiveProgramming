package leetcode.weekly_contests.weekly_25;

public class P_546 {

    static int[][][] dp;
    static boolean[][][] seen;

    public int removeBoxes(int[] boxes) {
        final int n = boxes.length;
        dp = new int[n][n][n + 1];
        seen = new boolean[n][n][n + 1];
        return dfs(boxes, 0, n - 1, 0);
    }

    private static int dfs(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        // important to do before checking cache
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        if (seen[l][r][k]) {
            return dp[l][r][k];
        }
        int res = (k + 1) * (k + 1) + dfs(boxes, l, r - 1, 0);
        for (int mid = l; mid < r; mid++) {
            if (boxes[mid] == boxes[r]) {
                res = Math.max(res, dfs(boxes, l, mid, k + 1) + dfs(boxes, mid + 1, r - 1, 0));
            }
        }
        seen[l][r][k] = true;
        return dp[l][r][k] = res;
    }
}
