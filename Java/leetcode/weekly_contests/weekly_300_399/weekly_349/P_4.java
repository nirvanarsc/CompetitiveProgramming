package leetcode.weekly_contests.weekly_300_399.weekly_349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return -1;
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

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        final int q = queries.length;
        final int n = nums1.length;
        final int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(sorted[i][1], val -> new ArrayList<>()).add(i);
        }
        final int[] forSt = new int[n];
        for (int i = 0; i < n; i++) {
            forSt[i] = sorted[i][0] + sorted[i][1];
        }
        final SegTree st = new SegTree(0, n - 1, forSt);
        final int[] res = new int[q];
        final int[][] sortedQ = new int[q][3];
        for (int i = 0; i < q; i++) {
            sortedQ[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        Arrays.sort(sortedQ, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(nums2);
        int j = 0;
        for (int i = 0; i < q; i++) {
            while (j < n && sortedQ[i][1] > nums2[j]) {
                for (int idx : g.getOrDefault(nums2[j], Collections.emptyList())) {
                    st.update(idx, -1);
                }
                g.remove(nums2[j]);
                j++;
            }
            res[sortedQ[i][2]] = st.query(lowerBound(sorted, sortedQ[i][0]), n - 1);
        }
        return res;
    }

    private static int lowerBound(int[][] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
