package leetcode.biweekly_contests.biweekly_0_99.biweekly_87;

public class P_3_ST {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int or;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                or = arr[leftMost];
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
            or = left.or | right.or;
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return or;
            }
            return left.query(l, r) | right.query(l, r);
        }
    }

    public int[] smallestSubarrays(int[] nums) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int max = st.query(i, n - 1);
            int lo = i;
            int hi = n;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (st.query(i, mid) < max) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            res[i] = lo - i + 1;
        }
        return res;
    }
}
