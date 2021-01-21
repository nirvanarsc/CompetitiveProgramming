package leetcode.weekly_contests.weekly_217;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        int remaining = nums.length - k;
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int num : nums) {
            while (!dq.isEmpty() && dq.getLast() > num && remaining > 0) {
                remaining--;
                dq.removeLast();
            }
            dq.addLast(num);
        }
        return dq.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int[] min = { Integer.MAX_VALUE, -1 };

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min[0] = arr[leftMost];
                min[1] = leftMost;
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
            if (left.min[0] <= right.min[0]) {
                min = left.min;
            } else {
                min = right.min;
            }
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { Integer.MAX_VALUE, -1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            final int[] ll = left.query(l, r);
            final int[] rr = right.query(l, r);
            if (ll[0] <= rr[0]) {
                return ll;
            } else {
                return rr;
            }
        }
    }

    public int[] mostCompetitiveST(int[] nums, int k) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        final int[] res = new int[k];
        int l = 0;
        for (int i = 0; i < k; i++) {
            final int[] min = st.query(l, n - k + i);
            res[i] = min[0];
            l = min[1] + 1;
        }
        return res;
    }
}
