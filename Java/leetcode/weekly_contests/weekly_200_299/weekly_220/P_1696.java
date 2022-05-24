package leetcode.weekly_contests.weekly_200_299.weekly_220;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1696 {

    public int maxResult(int[] nums, int k) {
        final int n = nums.length;
        final int[] dp = new int[n];
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getFirst() < i - k) {
                dq.removeFirst();
            }
            if (!dq.isEmpty()) {
                dp[i] += dp[dq.getFirst()];
            }
            dp[i] += nums[i];
            while (!dq.isEmpty() && dp[i] > dp[dq.getLast()]) {
                dq.removeLast();
            }
            dq.offerLast(i);
        }
        return dp[n - 1];
    }

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

    public int maxResultST(int[] nums, int k) {
        final int n = nums.length;
        final int[] arr = new int[n];
        arr[0] = nums[0];
        final SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 1; i < n; i++) {
            final int l = Math.max(0, i - k);
            st.update(i, nums[i] + st.query(l, i - 1));
        }
        return st.query(n - 1, n - 1);
    }
}
