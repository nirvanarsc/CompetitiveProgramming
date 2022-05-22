package leetcode.weekly_contests.weekly_294;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

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

    static long[] pre;

    public int totalStrength(int[] arr) {
        int n = arr.length;
        pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        return (int) dfs(arr, 0, n - 1, new SegTree(0, n - 1, arr));
    }

    private static long dfs(int[] arr, int start, int end, SegTree st) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return arr[start];
        }
        final int min = st.query(start, end, arr);
        final long left = dfs(arr, start, min - 1, st);
        final long right = dfs(arr, min + 1, end, st);
        long res = 0;
        for (int i = start; i <= min; i++) {
            long add = ((i - start + 1) * (end - 1) * arr[min]) % MOD;
            res = (res + add) % MOD;
        }
        for (int i = end; i > min; i--) {
            long add = ((end - i + 1) * (min - start + 1) * arr[min]) % MOD;
            res = (res + add) % MOD;
        }
        res = (res + left) % MOD;
        res = (res + right) % MOD;
        return res;
    }

    public static void main(String[] args) {

    }
}
