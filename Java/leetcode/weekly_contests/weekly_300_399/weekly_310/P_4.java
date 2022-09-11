package leetcode.weekly_contests.weekly_300_399.weekly_310;

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

        private int query(int l, int r) {
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

    public int lengthOfLIS(int[] nums, int k) {
        final int n = (int) (1e5 + 5);
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        int res = 0;
        for (int num : nums) {
            final int l = Math.max(0, num - k);
            final int r = num - 1;
            final int max = 1 + st.query(l, r);
            res = Math.max(res, max);
            st.update(num, max);
        }
        return res;
    }
}
