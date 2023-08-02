package leetcode.weekly_contests.weekly_300_399.weekly_349;

public class P_3 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int min;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
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
            min = Math.min(left.min, right.min);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return (int) 1e9;
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            return Math.min(left.query(l, r), right.query(l, r));
        }
    }

    public long minCost(int[] nums, int x) {
        final int n = nums.length;
        final int[] copy = new int[2 * n];
        System.arraycopy(nums, 0, copy, 0, n);
        System.arraycopy(nums, 0, copy, n, n);
        final SegTree st = new SegTree(0, copy.length - 1, copy);
        long res = (long) 9e18;
        for (int shift = 0; shift < n; shift++) {
            long curr = (long) shift * x;
            for (int i = 0; i < n; i++) {
                curr += st.query(i, i + shift);
            }
            res = Math.min(res, curr);
        }
        return res;
    }
}
