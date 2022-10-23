package leetcode.weekly_contests.weekly_300_399.weekly_316;

public class P_2 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int gcd;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                gcd = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            gcd = gcd(left.gcd, right.gcd);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return gcd;
            }
            return gcd(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                gcd = val;
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

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public int subarrayGCD(int[] nums, int k) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (st.query(i, j) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
