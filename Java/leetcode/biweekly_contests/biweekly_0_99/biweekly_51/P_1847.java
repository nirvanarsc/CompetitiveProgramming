package leetcode.biweekly_contests.biweekly_0_99.biweekly_51;

import java.util.Arrays;
import java.util.Comparator;

public class P_1847 {

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

        // rightMost index where arr[idx] >= k
        private int query2(int k) {
            if (max < k) {
                return -1;
            }
            if (leftMost == rightMost) {
                return id;
            }
            final int rr = right.query2(k);
            if (rr != -1) {
                return rr;
            }
            //noinspection TailRecursion
            return left.query2(k);
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

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        final int n = rooms.length;
        final int q = queries.length;
        final int[][] indexedQ = new int[q][3];
        for (int i = 0; i < q; i++) {
            indexedQ[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        Arrays.sort(rooms, Comparator.comparingInt(v -> v[0]));
        Arrays.sort(indexedQ, Comparator.comparingInt(v -> v[0]));
        final int[] right = new int[q];
        final int[] left = new int[q];
        final int[] res = new int[q];
        SegTree st = new SegTree(0, n - 1, new int[n][2]);
        int j = n - 1;
        for (int i = q - 1; i >= 0; i--) {
            final int currId = indexedQ[i][0];
            while (j >= 0 && rooms[j][0] >= currId) {
                st.update(j, rooms[j]);
                j--;
            }
            right[indexedQ[i][2]] = st.query1(indexedQ[i][1]);
        }
        st = new SegTree(0, n - 1, new int[n][2]);
        j = 0;
        for (int i = 0; i < q; i++) {
            final int currId = indexedQ[i][0];
            while (j < n && rooms[j][0] <= currId) {
                st.update(j, rooms[j]);
                j++;
            }
            left[indexedQ[i][2]] = st.query2(indexedQ[i][1]);
        }
        for (int i = 0; i < q; i++) {
            if (left[i] == -1) {
                res[i] = right[i];
            } else if (right[i] == -1) {
                res[i] = left[i];
            } else {
                if (right[i] - queries[i][0] == queries[i][0] - left[i]) {
                    res[i] = left[i];
                } else if (right[i] - queries[i][0] < queries[i][0] - left[i]) {
                    res[i] = right[i];
                } else {
                    res[i] = left[i];
                }
            }
        }
        return res;
    }
}
