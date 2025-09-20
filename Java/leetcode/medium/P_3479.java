package leetcode.medium;

public class P_3479 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;
        int id;

        SegTree(int leftMost, int rightMost, int[][] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                id = arr[leftMost][0];
                max = arr[leftMost][1];
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

        // leftmost index where arr[idx] >= k
        private int query1(int k) {
            if (max < k) {
                return -1;
            }
            if (leftMost == rightMost) {
                return id;
            }
            final int ll = left.query1(k);
            if (ll != -1) {
                return ll;
            }
            //noinspection TailRecursion
            return right.query1(k);
        }

        private void update(int idx, int[] val) {
            if (leftMost == rightMost) {
                id = val[0];
                max = val[1];
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

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        final int n = fruits.length;
        final int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { i, baskets[i] };
        }
        final SegTree st = new SegTree(0, n - 1, indexed);
        int res = 0;
        for (int fruit : fruits) {
            final int u = st.query1(fruit);
            if (u != -1) {
                st.update(u, new int[] { u, -1 });
            } else {
                res++;
            }
        }
        return res;
    }
}
