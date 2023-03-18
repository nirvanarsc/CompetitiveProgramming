package leetcode.biweekly_contests.biweekly_0_99.biweekly_79;

import java.util.Arrays;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class BookMyShow {

        private class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            int max;
            long sum;

            SegTree(int leftMost, int rightMost, int[] arr) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
                if (leftMost == rightMost) {
                    max = arr[leftMost];
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
                max = Math.max(left.max, right.max);
                sum = left.sum + right.sum;
            }

            // leftMost index that is <= r and where arr[idx] <= k
            private int queryFirstMax(int k, int r) {
                if (max < k || leftMost > r) {
                    return -1;
                }
                if (leftMost == rightMost) {
                    return leftMost;
                }
                final int resL = left.queryFirstMax(k, r);
                return resL != -1 ? resL : right.queryFirstMax(k, r);
            }

            private int queryMax(int l, int r) {
                if (r < leftMost || l > rightMost) {
                    return Integer.MIN_VALUE;
                }
                if (l <= leftMost && rightMost <= r) {
                    return max;
                }
                return Math.max(left.queryMax(l, r), right.queryMax(l, r));
            }

            private long querySum(int l, int r) {
                if (r < leftMost || l > rightMost) {
                    return 0;
                }
                if (l <= leftMost && rightMost <= r) {
                    return sum;
                }
                return left.querySum(l, r) + right.querySum(l, r);
            }

            private void update(int idx, int val) {
                if (leftMost == rightMost) {
                    max = val;
                    sum = val;
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

        int col;
        int[] rows;
        SegTree st;

        public BookMyShow(int n, int m) {
            rows = new int[n];
            col = m;
            Arrays.fill(rows, m);
            st = new SegTree(0, n - 1, rows);
        }

        public int[] gather(int k, int maxRow) {
            final int idx = st.queryFirstMax(k, maxRow);
            if (idx == -1) {
                //noinspection ZeroLengthArrayAllocation
                return new int[0];
            }
            final int curr = st.queryMax(idx, idx);
            st.update(idx, st.queryMax(idx, idx) - k);
            return new int[] { idx, col - curr };
        }

        public boolean scatter(int k, int maxRow) {
            final long s = st.querySum(0, maxRow);
            if (s < k) {
                return false;
            }
            while (k > 0) {
                final int idx = st.queryFirstMax(1, maxRow);
                final int curr = st.queryMax(idx, idx);
                final int take = Math.min(k, curr);
                k -= take;
                st.update(idx, curr - take);
            }
            return true;
        }
    }
}
