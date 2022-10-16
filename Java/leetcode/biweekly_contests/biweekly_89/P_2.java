package leetcode.biweekly_contests.biweekly_89;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long prod;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                prod = arr[leftMost];
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
            prod = (left.prod * right.prod) % MOD;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 1;
            }
            if (l <= leftMost && rightMost <= r) {
                return prod;
            }
            return (left.query(l, r) * right.query(l, r)) % MOD;
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        final int[] p = new int[Integer.bitCount(n)];
        for (int i = 0, idx = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                p[idx++] = 1 << i;
            }
        }
        final SegTree st = new SegTree(0, p.length - 1, p);
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            res[i] = (int) st.query(queries[i][0], queries[i][1]);
        }
        return res;
    }
}
