package leetcode.weekly_contests.weekly_49;

public class P_673 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int[] value;

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            value = merge(left.value, right.value);
        }

        private void createChildren() {
            if (left == null || right == null) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
                recalc();
            }
        }

        public int[] merge(int[] v1, int[] v2) {
            if (v1[0] == 0 && v2[0] == 0) {
                return new int[] { 0, 1 };
            }
            if (v1[0] == v2[0]) {
                return new int[] { v1[0], v1[1] + v2[1] };
            }
            return v1[0] > v2[0] ? v1 : v2;
        }

        private int[] query(int l, int r) {
            createChildren();
            if (r < leftMost || l > rightMost) {
                return new int[] { 0, 1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return value;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int[] val) {
            createChildren();
            if (leftMost == rightMost) {
                value = merge(value, val);
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

    public int findNumberOfLISST(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (int) 1e6;
        }
        final SegTree st = new SegTree(0, (int) 2e6);
        for (int num : nums) {
            final int[] val = st.query(0, num - 1);
            st.update(num, new int[] { val[0] + 1, val[1] });
        }
        return st.value[1];
    }

    public int findNumberOfLIS(int[] nums) {
        final int n = nums.length;
        final int[][] dp = new int[n][2];
        int lis = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int currLis = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (currLis < 1 + dp[j][0]) {
                        currLis = 1 + dp[j][0];
                        count = dp[j][1];
                    } else if (currLis == 1 + dp[j][0]) {
                        count += dp[j][1];
                    }
                }
            }
            dp[i][0] = currLis;
            dp[i][1] = count;
            lis = Math.max(lis, currLis);
        }
        int res = 0;
        for (int[] row : dp) {
            if (row[0] == lis) {
                res += row[1];
            }
        }
        return res;
    }
}
