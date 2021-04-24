package binarysearch.weekly_50;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_4 {

    // Addition and Min
    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long min;
        long operation;

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
            min = Math.min(applyAggregate(left), applyAggregate(right));
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.compose(operation);
            right.compose(operation);
            operation = 0;
        }

        private void compose(long add) {
            operation += add;
        }

        private static long applyAggregate(SegTree curr) {
            return curr.min + curr.operation;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return (long) 1e18;
            }
            if (l <= leftMost && rightMost <= r) {
                return applyAggregate(this);
            }
            propagate();
            recalc();
            return Math.min(left.query(l, r), right.query(l, r));
        }

        private void update(int l, int r, long add) {
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                compose(add);
                return;
            }
            propagate();
            left.update(l, r, add);
            right.update(l, r, add);
            recalc();
        }
    }

    public boolean solve(int[][] producers, int[][] consumers) {
        final Set<Integer> times = new HashSet<>();
        for (int[] p : producers) {
            times.add(p[0]);
            times.add(p[1]);
        }
        for (int[] p : consumers) {
            times.add(p[0]);
            times.add(p[1]);
        }
        if (times.isEmpty()) {
            return true;
        }
        final List<Integer> l = new ArrayList<>(times);
        l.sort(Comparator.naturalOrder());
        final Map<Integer, Integer> normalized = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < l.size(); i++) {
            if (i > 0 && l.get(i) - l.get(i - 1) > 1) {
                idx++;
            }
            normalized.put(l.get(i), idx++);
        }
        final SegTree st = new SegTree(0, idx - 1, new int[idx]);
        for (int[] p : producers) {
            final int ll = normalized.get(p[0]);
            final int rr = normalized.get(p[1]);
            st.update(ll, rr, p[2]);
        }
        for (int[] p : consumers) {
            final int ll = normalized.get(p[0]);
            final int rr = normalized.get(p[1]);
            if (st.query(ll, rr) < p[2]) {
                return false;
            }
            st.update(ll, rr, -p[2]);
        }
        return true;
    }
}
