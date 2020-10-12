package leetcode.weekly_contests.weekly_98;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_891 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long res = 0, sum = A[0], now = 2;
        for (int i = 1; i < A.length; i++) {
            res = (res + A[i] * (now - 1) - sum) % MOD;
            sum = (sum * 2 + A[i]) % MOD;
            now = (now * 2) % MOD;
        }
        return (int) res;
    }

    public int sumSubseqWidthsLee(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0;
        for (int i = 0, n = A.length; i < n; i++, c = c * 2 % MOD) {
            res = (res + (A[i] - A[n - i - 1]) * c) % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}
