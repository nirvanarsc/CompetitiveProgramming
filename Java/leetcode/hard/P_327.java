package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_327 {

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

    public int countRangeSum(int[] nums, int lower, int upper) {
        int idx = 0;
        int res = 0;
        final int n = nums.length;
        final long[] sum = new long[n + 1];
        final long[] range = new long[3 * sum.length];
        final SegTree st = new SegTree(0, range.length - 1, new int[range.length]);
        for (int i = 0; i <= n; i++) {
            sum[i] = i == 0 ? 0 : (sum[i - 1] + nums[i - 1]);
            range[idx++] = sum[i];
            range[idx++] = lower + sum[i];
            range[idx++] = upper + sum[i];
        }
        Arrays.sort(range);
        final Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < range.length; i++) {
            map.put(range[i], i);
        }
        for (long val : sum) {
            st.update(map.get(val), 1);
        }
        for (long val : sum) {
            st.update(map.get(val), -1);
            res += st.query(map.get(val + lower), map.get(val + upper));
        }
        return res;
    }
}
