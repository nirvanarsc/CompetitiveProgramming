package leetcode.weekly_contests.weekly_300_399.weekly_375;

import java.util.Arrays;

public class P_3 {

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

    public long countSubarrays(int[] nums, int k) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n, new int[n + 1]);
        st.update(0, 1);
        long res = 0;
        int curr = 0;
        final int max = Arrays.stream(nums).max().orElse(-1);
        for (int num : nums) {
            curr += num == max ? 1 : 0;
            res += st.query(0, curr - k);
            st.update(curr, 1);
        }
        return res;
    }
}
