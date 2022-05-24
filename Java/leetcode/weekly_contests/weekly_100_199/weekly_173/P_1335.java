package leetcode.weekly_contests.weekly_100_199.weekly_173;

import java.util.Arrays;

public class P_1335 {

    private static final int INF = (int) 1e9;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        return recurse(0, d, jobDifficulty, new Integer[jobDifficulty.length][d + 1]);
    }

    private static int recurse(int start, int d, int[] jobs, Integer[][] dp) {
        if (d == 0 && start == jobs.length) {
            return 0;
        }
        if (d == 0 || start == jobs.length) {
            return INF;
        }
        if (dp[start][d] != null) {
            return dp[start][d];
        }

        int add = jobs[start];
        int res = INF;
        for (int j = start; j < jobs.length; j++) {
            add = Math.max(add, jobs[j]);
            final int startNew = recurse(j + 1, d - 1, jobs, dp);
            if (startNew != INF) {
                res = Math.min(res, startNew + add);
            }
        }
        return dp[start][d] = res;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            max = Math.max(left.max, right.max);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return Integer.MIN_VALUE;
            }
            if (l <= leftMost && rightMost <= r) {
                return max;
            }
            return Math.max(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = val;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, val);
                } else {
                    right.update(idx, val);
                }
                recalc();
            }
        }
    }

    public int minDifficultyST(int[] jobDifficulty, int d) {
        final int n = jobDifficulty.length;
        final SegTree st = new SegTree(0, n - 1, jobDifficulty);
        final int[][][] dp = new int[n][n][d + 1];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        final int res = dfs(jobDifficulty, 0, 0, 0, d, st, dp);
        return res == (int) 1e6 ? -1 : res;
    }

    private static int dfs(int[] arr, int idx, int prev, int day, int d, SegTree st, int[][][] dp) {
        if (idx == arr.length) {
            return day == d && prev == arr.length ? 0 : (int) 1e6;
        }
        if (dp[idx][prev][day] != -1) {
            return dp[idx][prev][day];
        }
        int res = (int) 1e6;
        res = Math.min(res, dfs(arr, idx + 1, prev, day, d, st, dp));
        if (day < d) {
            res = Math.min(res, st.query(prev, idx) + dfs(arr, idx + 1, idx + 1, day + 1, d, st, dp));
        }
        return dp[idx][prev][day] = res;
    }
}
