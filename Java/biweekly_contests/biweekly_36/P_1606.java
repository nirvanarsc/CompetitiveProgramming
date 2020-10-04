package biweekly_contests.biweekly_36;

import java.util.ArrayList;
import java.util.List;

public class P_1606 {

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

        private int query(int idx, int val) {
            if (min > val || rightMost < idx) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resL = left.query(idx, val);
            return resL != -1 ? resL : right.query(idx, val);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                min = val;
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

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        final int[] handled = new int[k];
        final List<Integer> res = new ArrayList<>();
        final SegTree st = new SegTree(0, k - 1, new int[k]);
        for (int i = 0; i < arrival.length; i++) {
            final int target = i % k;
            int pos = st.query(target, arrival[i]);
            if (pos < target) {
                pos = st.query(0, arrival[i]);
            }
            if (pos != -1) {
                handled[pos]++;
                st.update(pos, arrival[i] + load[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, handled[i]);
        }
        for (int i = 0; i < k; i++) {
            if (handled[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
