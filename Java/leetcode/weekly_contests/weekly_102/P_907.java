package leetcode.weekly_contests.weekly_102;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_907 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMinsStack(int[] A) {
        final Deque<int[]> stack1 = new ArrayDeque<>();
        final Deque<int[]> stack2 = new ArrayDeque<>();
        final int[] left = new int[A.length];
        final int[] right = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int curr = 1;
            while (!stack1.isEmpty() && stack1.peekFirst()[0] > A[i]) {
                curr += stack1.removeFirst()[1];
            }
            stack1.addFirst(new int[] { A[i], curr });
            left[i] = curr;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int curr = 1;
            while (!stack2.isEmpty() && stack2.peekFirst()[0] >= A[i]) {
                curr += stack2.removeFirst()[1];
            }
            stack2.addFirst(new int[] { A[i], curr });
            right[i] = curr;
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = (res + left[i] * right[i] * A[i]) % MOD;
        }
        return res;
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

    public int sumSubarrayMins(int[] A) {
        return dfs(A, 0, A.length - 1, new SegTree(0, A.length - 1, A));
    }

    private static int dfs(int[] A, int start, int end, SegTree st) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return A[start];
        }
        final int min = st.query(start, end, A);
        final int left = dfs(A, start, min - 1, st);
        final int right = dfs(A, min + 1, end, st);
        int res = (min - start + 1) * A[min] * (end - min + 1);
        res = (res + left) % MOD;
        res = (res + right) % MOD;
        return res;
    }
}
