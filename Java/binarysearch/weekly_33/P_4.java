package binarysearch.weekly_33;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = 1;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = left.sum + right.sum;
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum = val;
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

    public int[] solve(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        final int n = nums.length;
        final int[] res = new int[n];
        final List<int[]> pairs = new ArrayList<>(n);
        final SegTree st = new SegTree(0, n + 5);
        for (int i = 0; i < n; i++) {
            pairs.add(new int[] { nums[i], i });
        }
        pairs.sort(Comparator.comparingInt(val -> val[0]));
        for (int i = 0; i < n; i++) {
            final int idx = pairs.get(i)[1];
            res[i] = st.query(0, idx - 1);
            st.update(idx, 0);
        }
        return res;
    }
}
