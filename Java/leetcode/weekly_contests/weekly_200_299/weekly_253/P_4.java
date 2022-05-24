package leetcode.weekly_contests.weekly_200_299.weekly_253;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;
        int idx;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                idx = leftMost;
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
            if (left.max >= right.max) {
                idx = left.idx;
            } else {
                idx = right.idx;
            }
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { (int) -1e9, -1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return new int[] { max, idx };
            }
            final int[] ll = left.query(l, r);
            final int[] rr = right.query(l, r);
            if (ll[0] >= rr[0]) {
                return ll;
            } else {
                return rr;
            }
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = val;
                this.idx = idx;
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

    public int[] longestObstacleCourseAtEachPositionST(int[] obstacles) {
        int idx = 0;
        final TreeSet<Integer> ts = new TreeSet<>();
        final Map<Integer, Integer> normalized = new HashMap<>();
        for (int num : obstacles) {
            ts.add(num);
        }
        for (int num : ts) {
            normalized.put(num, idx++);
        }
        final int[] arr = new int[idx];
        final SegTree st = new SegTree(0, idx - 1, arr);
        final int n = obstacles.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int currIdx = normalized.get(obstacles[i]);
            final int[] qq = st.query(0, currIdx);
            st.update(currIdx, qq[0] + 1);
            res[i] = qq[0] + 1;
        }
        return res;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;
        final int[] res = new int[n];
        final int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            final int num = obstacles[i];
            int idx = upperBound(dp, num, len);
            if (dp[idx] != 0 && dp[idx] <= num) {
                idx++;
            }
            if (idx == len) {
                len++;
            }
            dp[idx] = num;
            res[i] = idx + 1;
        }
        return res;
    }

    private static int upperBound(int[] arr, int target, int to) {
        int lo = 0;
        int hi = to - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
