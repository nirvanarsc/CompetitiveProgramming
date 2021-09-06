package leetcode.weekly_contests.weekly_257;

import java.util.Arrays;
import java.util.Comparator;

public class P_2 {

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

    public int numberOfWeakCharacters(int[][] properties) {
        final int n = properties.length;
        Arrays.sort(properties, Comparator.comparingInt(a -> a[0]));
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = properties[i][1];
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        int res = 0;
        for (int[] p : properties) {
            final int idx = lowerBound(properties, p[0] + 1);
            final int max = st.query(idx, n - 1);
            if (max != (int) -1e9 && p[1] < max) {
                res++;
            }
        }
        return res;
    }

    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
