package leetcode.weekly_contests.weekly_214;

public class P_1649 {

    private static final int MOD = (int) (1e9 + 7);

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

    public int createSortedArray(int[] instructions) {
        final int n = (int) (1e5 + 5);
        final int[] arr = new int[n];
        final SegTree st = new SegTree(0, n - 1, arr);
        long res = 0;
        for (int num : instructions) {
            final long ll = st.query(0, num - 1);
            final long rr = st.query(num + 1, n - 1);
            res = (res + Math.min(ll, rr)) % MOD;
            st.update(num, 1);
        }
        return (int) res;
    }
}
