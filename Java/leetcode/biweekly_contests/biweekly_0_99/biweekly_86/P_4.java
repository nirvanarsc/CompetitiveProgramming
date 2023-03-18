package leetcode.biweekly_contests.biweekly_0_99.biweekly_86;

public class P_4 {

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

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
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

    static SegTree st;
    static long[] pre;
    static long b;

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        final int n = chargeTimes.length;
        int lo = 0;
        int hi = n;
        st = new SegTree(0, n - 1, chargeTimes);
        pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + runningCosts[i - 1];
        }
        b = budget;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(n, mid)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static boolean f(int n, int k) {
        for (int i = 0; i < n - k + 1; i++) {
            final long curr = (pre[i + k] - pre[i]) * k + st.query(i, i + k - 1);
            if (curr <= b) {
                return true;
            }
        }
        return false;
    }
}
