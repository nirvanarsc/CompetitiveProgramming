package leetcode.weekly_contests.weekly_186;

public class P_1425 {

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
                return (int) -2e9;
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

    public int constrainedSubsetSum(int[] nums, int k) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        int res = (int) -1e5;
        for (int i = 1; i <= n; i++) {
            final int prev = st.query(Math.max(0, i - k), i - 1);
            final int curr = Math.max(nums[i - 1], prev + nums[i - 1]);
            res = Math.max(res, curr);
            st.update(i, curr);
        }
        return res;
    }
}
