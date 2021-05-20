package binarysearch.weekly_43;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

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
                return (int) -1e9;
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

    public int[] solve(int[] heights, int k) {
        final int n = heights.length;
        if (n == 0) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0];
        }
        final SegTree st = new SegTree(0, n - 1, heights);
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (k == 0) {
                res.add(i);
            } else {
                final int l = i + 1;
                final int r = Math.min(n - 1, i + k);
                if (heights[i] > st.query(l, r)) {
                    res.add(i);
                }
            }
        }
        res.add(n - 1);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
