package weekly_contests.weekly_94;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_873 {

    public int lenLongestFibSubseq(int[] A) {
        final int[][] dp = new int[A.length][A.length];
        int max = 0;
        for (int i = 2; i < A.length; i++) {
            int start = 0, end = i - 1;
            while (start < end) {
                final int sum = A[start] + A[end];
                if (sum > A[i]) {
                    end--;
                } else if (sum < A[i]) {
                    start++;
                } else {
                    dp[end][i] = dp[start][end] + 1;
                    max = Math.max(max, dp[end][i]);
                    start++;
                    end--;
                }
            }
        }
        return max == 0 ? max : max + 2;
    }

    public int lenLongestFibSubseqTopDown(int[] A) {
        int max = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) { map.put(A[i], i); }
        final Integer[][] dp = new Integer[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(recurse(A, i, j, map, dp), max);
            }
        }
        return max == 0 ? max : max + 2;
    }

    private static int recurse(int[] A, int i, int j, Map<Integer, Integer> map, Integer[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int max = 0;
        if (map.getOrDefault(A[i] + A[j], -1) > j) {
            max = Math.max(max, recurse(A, j, map.get(A[i] + A[j]), map, dp) + 1);
        }
        return dp[i][j] = max;
    }
}
