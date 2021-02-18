package leetcode.medium;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_413 {

    public int numberOfArithmeticSlicesDP(int[] A) {
        final int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices(int[] A) {
        final int n = A.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n && A[j] - A[j - 1] == A[i + 1] - A[i]) {
                j++;
            }
            final int curr = j - i - 1;
            res += (curr * (curr - 1)) / 2;
            i = j - 2;
        }
        return res;
    }
}
