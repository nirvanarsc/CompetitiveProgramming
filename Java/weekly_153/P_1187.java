package weekly_153;

import java.util.Arrays;
import java.util.TreeSet;

public class P_1187 {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int value : arr2) {
            ts.add(value);
        }
        final int[][] dp = new int[arr1.length + 1][arr1.length + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = -1;

        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (arr1[j - 1] > dp[i][j - 1]) {
                    dp[i][j] = arr1[j - 1];
                }
                if (i > 0) {
                    final Integer higher = ts.higher(dp[i - 1][j - 1]);
                    if (higher != null) {
                        dp[i][j] = Math.min(dp[i][j], higher);
                    }
                }
                if (j == dp.length - 1 && dp[i][j] != Integer.MAX_VALUE) {
                    return i;
                }
            }
        }
        return -1;
    }
}
