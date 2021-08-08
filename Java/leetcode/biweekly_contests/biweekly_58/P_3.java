package leetcode.biweekly_contests.biweekly_58;

public class P_3 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;
        int sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = sum = arr[leftMost];
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
            sum = left.sum + right.sum;
        }

        private int queryMax(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return (int) -1e9;
            }
            if (l <= leftMost && rightMost <= r) {
                return max;
            }
            return Math.max(left.queryMax(l, r), right.queryMax(l, r));
        }

        private int querySum(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.querySum(l, r) + right.querySum(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = sum = val;
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

    static boolean[][] seen;
    static int[][] dp;
    static int[][] g1;
    static int[][] g2;
    static SegTree st;

    public int minSpaceWastedKResizing(int[] nums, int k) {
        final int n = nums.length;
        st = new SegTree(0, n - 1, nums);
        g1 = new int[n][n];
        g2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g1[i][j] = st.queryMax(i, j);
                g2[i][j] = st.querySum(i, j);
            }
        }
        seen = new boolean[n][n];
        dp = new int[n][n];
        return dfs(nums, 0, k);
    }

    private static int dfs(int[] nums, int idx, int k) {
        if (idx == nums.length) {
            return 0;
        }
        if (k == 0) {
            final int L = nums.length - idx;
            return L * g1[idx][nums.length - 1] - g2[idx][nums.length - 1];
        }
        if (seen[idx][k]) {
            return dp[idx][k];
        }
        int res = (int) 1e9;
        for (int i = idx; i < nums.length; i++) {
            final int L = i - idx + 1;
            final int cost = L * g1[idx][i] - g2[idx][i];
            res = Math.min(res, cost + dfs(nums, i + 1, k - 1));
        }
        seen[idx][k] = true;
        return dp[idx][k] = res;
    }
}
