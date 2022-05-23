package leetcode.weekly_contests.weekly_294;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int totalStrength(int[] arr) {
        final int n = arr.length;
        final Deque<Integer> dq = new ArrayDeque<>();
        final int[] left = new int[n];
        final int[] right = new int[n];
        final long[] pre = new long[n + 1];
        final long[] prePre = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        for (int i = 1; i <= (n + 1); i++) {
            prePre[i] = (prePre[i - 1] + pre[i - 1]) % MOD;
        }
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.getFirst()] > arr[i]) {
                dq.removeFirst();
            }
            left[i] = dq.isEmpty() ? -1 : dq.getFirst();
            dq.addFirst(i);
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && arr[dq.getFirst()] >= arr[i]) {
                dq.removeFirst();
            }
            right[i] = dq.isEmpty() ? n : dq.getFirst();
            dq.addFirst(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            final long l = sum(prePre, left[i], i) * (right[i] - i) % MOD;
            final long r = sum(prePre, i, right[i]) * (i - left[i]) % MOD;
            final long sum = (r - l + MOD) % MOD;
            final long add = sum * arr[i];
            res = (res + add) % MOD;
        }
        return (int) res;
    }

    private static long sum(long[] pre, int l, int r) {
        return (pre[r + 1] - pre[l + 1] + MOD) % MOD;
    }
}
