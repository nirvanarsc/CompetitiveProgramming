package leetcode.biweekly_contests.biweekly_0_99.biweekly_88;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = merge(left.sum, right.sum);
        }

        private void createChildren() {
            if (left == null || right == null) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
                recalc();
            }
        }

        public int merge(int l, int r) {
            return l + r;
        }

        private int query(int l, int r) {
            createChildren();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int val) {
            createChildren();
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

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        final int n = nums1.length;
        long res = 0;
        final int m = (int) 3e4;
        final SegTree st = new SegTree(0, 2 * m + 5);
        for (int i = 0; i < n; i++) {
            final int u = nums1[i] - nums2[i];
            res += st.query(0, u + m);
            st.update(u - diff + m, 1);
        }
        return res;
    }
}
