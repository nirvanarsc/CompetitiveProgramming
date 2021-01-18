package leetcode.weekly_contests.smarking_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

public class P_456 {

    public boolean find132patternStack(int[] nums) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int max = (int) -1e9;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() < nums[i]) {
                max = stack.removeFirst();
            }
            if (nums[i] > max) { stack.addFirst(nums[i]); }
            if (nums[i] < max) { return true; }
        }
        return false;
    }

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

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return Integer.MAX_VALUE;
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            return Math.min(left.query(l, r), right.query(l, r));
        }
    }

    public boolean find132pattern(int[] nums) {
        final int n = nums.length;
        final SegTree stMin = new SegTree(0, n - 1, nums);
        final TreeSet<Integer> ts = new TreeSet<>();
        boolean res = false;
        for (int i = n - 1; i >= 1; i--) {
            final Integer right = ts.lower(nums[i]);
            ts.add(nums[i]);
            if (right == null) {
                continue;
            }
            final int left = stMin.query(0, i - 1);
            res |= left < right && left < nums[i] && right < nums[i];
        }
        return res;
    }
}
