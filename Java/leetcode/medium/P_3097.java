package leetcode.medium;

public class P_3097 {

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

    public int minimumSubarrayLength(int[] nums, int k) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        if (st.or < k) {
            return -1;
        }
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            boolean ok = false;
            for (int i = 0; i < n - mid + 1; i++) {
                if (st.query(i, i + mid - 1) >= k) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
