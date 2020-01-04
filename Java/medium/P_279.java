package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_279 {

    // https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem
    public int numSquaresMath(int n) {
        // four-square and three-square theorems
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }
        // enumeration to check if the number can be decomposed into sum of two squares
        for (int i = 1; i * i <= n; ++i) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        // bottom case of three-square theorem
        return 3;
    }

    private static boolean isSquare(int n) {
        final int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public static int numSquaresBottomUp(int n) {
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    public static int numSquares(int n) {
        return recurse(n, new HashMap<>());
    }

    private static int recurse(int n, Map<Integer, Integer> dp) {
        if (n == 0) {
            return 0;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + recurse(n - (i * i), dp));
        }
        dp.put(n, res);
        return dp.get(n);
    }
}
