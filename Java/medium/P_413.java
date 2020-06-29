package medium;

import java.util.Arrays;

public class P_413 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numberOfArithmeticSlices(int[] A) {
        final int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum;
    }
}
