package leetcode.weekly_contests.weekly_300_399.weekly_332;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P_2 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

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

        private int query(int l, int r) {
            if (l > rightMost || r < leftMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum += val;
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

    static TreeMap<Integer, Integer> norm;
    static int n;

    public long countFairPairs(int[] nums, int lower, int upper) {
        final int[] clone = nums.clone();
        Arrays.sort(clone);
        norm = new TreeMap<>();
        n = nums.length;
        for (int i = 0; i < n; i++) {
            norm.put(clone[i], i);
        }
        return f(nums, upper) - f(nums, lower - 1);
    }

    private static long f(int[] nums, int limit) {
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        long res = 0;
        for (int i = 0; i < n; i++) {
            final Map.Entry<Integer, Integer> e = norm.floorEntry(limit - nums[i]);
            res += st.query(0, e == null ? -1 : e.getValue());
            st.update(norm.get(nums[i]), 1);
        }
        return res;
    }
}
