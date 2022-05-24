package leetcode.weekly_contests.weekly_100_199.weekly_102;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_907 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int n = arr.length;
        final int[] left = new int[n];
        final int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] > arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            left[i] = curr;
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] >= arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            right[i] = curr;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            final long add = ((long) left[i] * right[i] * arr[i]) % MOD;
            res = (res + add) % MOD;
        }
        return (int) res;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int minIdx;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                minIdx = leftMost;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                minIdx = arr[left.minIdx] < arr[right.minIdx] ? left.minIdx : right.minIdx;
            }
        }

        private int query(int l, int r, int[] arr) {
            if (l > rightMost || r < leftMost) {
                return -1;
            }
            if (l <= leftMost && rightMost <= r) {
                return minIdx;
            }
            final int ll = left.query(l, r, arr);
            final int rr = right.query(l, r, arr);
            if (ll == -1) {
                return rr;
            }
            if (rr == -1) {
                return ll;
            }
            return arr[ll] < arr[rr] ? ll : rr;
        }
    }

    public int sumSubarrayMinsST(int[] arr) {
        return dfs(arr, 0, arr.length - 1, new SegTree(0, arr.length - 1, arr));
    }

    private static int dfs(int[] arr, int start, int end, SegTree st) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return arr[start];
        }
        final int min = st.query(start, end, arr);
        final int left = dfs(arr, start, min - 1, st);
        final int right = dfs(arr, min + 1, end, st);
        int res = (min - start + 1) * arr[min] * (end - min + 1);
        res = (res + left) % MOD;
        res = (res + right) % MOD;
        return res;
    }
}
