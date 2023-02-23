package leetcode.weekly_contests.weekly_0_99.weekly_18a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class P_502 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;
        int idx;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                idx = leftMost;
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
            if (left.max >= right.max) {
                idx = left.idx;
            } else {
                idx = right.idx;
            }
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { (int) -1e9, -1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return new int[] { max, idx };
            }
            final int[] ll = left.query(l, r);
            final int[] rr = right.query(l, r);
            if (ll[0] >= rr[0]) {
                return ll;
            } else {
                return rr;
            }
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = val;
                this.idx = idx;
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

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int n = profits.length;
        final int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { profits[i], capital[i] };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[1]));
        final int[] forSt = new int[n];
        for (int i = 0; i < n; i++) {
            forSt[i] = sorted[i][0];
        }
        final SegTree st = new SegTree(0, n - 1, forSt);
        final TreeMap<Long, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tm.put((long) sorted[i][1], i);
        }
        long curr = w;
        for (int i = 0; i < k; i++) {
            final Map.Entry<Long, Integer> e = tm.floorEntry(curr);
            if (e == null) {
                break;
            }
            final int[] q = st.query(0, e.getValue());
            curr += q[0];
            st.update(q[1], 0);
        }
        return (int) curr;
    }
}
