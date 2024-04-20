package leetcode.weekly_contests.weekly_300_399.weekly_372;

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

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        final int n = heights.length;
        final SegTree st = new SegTree(0, n - 1, heights);
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            if (u == v) {
                res[i] = u;
            } else if (u < v && heights[u] < heights[v]) {
                res[i] = v;
            } else if (v < u && heights[v] < heights[u]) {
                res[i] = u;
            } else {
                res[i] = st.query(Math.max(heights[u], heights[v]), Math.max(u, v));
            }
        }
        return res;
    }
}
