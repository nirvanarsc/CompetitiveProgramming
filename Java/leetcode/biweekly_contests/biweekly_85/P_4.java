package leetcode.biweekly_contests.biweekly_85;

import java.util.TreeMap;
import java.util.TreeSet;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
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
            sum = left.sum + right.sum;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, long val) {
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

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        final int n = nums.length;
        final int q = removeQueries.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        final TreeSet<Integer> removals = new TreeSet<>();
        final TreeMap<Long, Integer> tm = new TreeMap<>();
        inc(tm, st.sum);
        final long[] res = new long[q];
        for (int i = 0; i < q; i++) {
            final int u = removeQueries[i];
            Integer l = removals.lower(u);
            Integer r = removals.higher(u);
            if (l == null) {
                l = 0;
            }
            if (r == null) {
                r = n - 1;
            }
            dec(tm, st.query(l, r));
            st.update(u, 0);
            inc(tm, st.query(l, u));
            inc(tm, st.query(u, r));
            res[i] = tm.lastKey();
            removals.add(u);
        }
        return res;
    }

    private static void dec(TreeMap<Long, Integer> tm, long u) {
        if (tm.merge(u, -1, Integer::sum) == 0) {
            tm.remove(u);
        }
    }

    private static void inc(TreeMap<Long, Integer> tm, long u) {
        tm.merge(u, 1, Integer::sum);
    }
}
