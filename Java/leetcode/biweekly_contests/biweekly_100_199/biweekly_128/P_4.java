package leetcode.biweekly_contests.biweekly_100_199.biweekly_128;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

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

    public long numberOfSubarrays(int[] nums) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }
        long res = 0;
        for (List<Integer> l : g.values()) {
            int ll = l.get(0);
            long curr = 0;
            for (int rr : l) {
                if (st.query(ll, rr) > nums[rr]) {
                    res += (curr * (curr + 1)) / 2;
                    ll = rr;
                    curr = 1;
                } else {
                    curr++;
                }
            }
            res += (curr * (curr + 1)) / 2;
        }
        return res;
    }
}
