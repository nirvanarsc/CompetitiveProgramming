package leetcode.biweekly_contests.biweekly_90;

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

        // leftMost index that is > l and where arr[idx] > k
        private int query(int k, int l) {
            if (max <= k || rightMost <= l) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resL = left.query(k, l);
            return resL != -1 ? resL : right.query(k, l);
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

    public int[] secondGreaterElement(int[] nums) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        final int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int u = st.query(nums[i], i);
            if (u != -1) {
                u = st.query(nums[i], u);
            }
            res[i] = u == -1 ? -1 : nums[u];
            st.update(i, nums[i]);
        }
        return res;
    }
}
