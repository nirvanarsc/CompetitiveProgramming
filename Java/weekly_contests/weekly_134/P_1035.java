package weekly_contests.weekly_134;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_1035 {

    public int maxUncrossedLinesLCS(int[] A, int[] B) {
        final int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= B.length; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        final Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.computeIfAbsent(A[i], v -> new TreeSet<>()).add(i);
        }
        return recurse(B, 0, 0, map, new Integer[B.length + 1][A.length + 1]);
    }

    private static int recurse(int[] arr, int i, int prev, Map<Integer, TreeSet<Integer>> map, Integer[][] dp) {
        if (i == arr.length) {
            return 0;
        }
        if (dp[i][prev] != null) {
            return dp[i][prev];
        }

        final Integer nextMatchingIdx = map.getOrDefault(arr[i], new TreeSet<>()).ceiling(prev);
        int take = 0;
        if (nextMatchingIdx != null) {
            take = 1 + recurse(arr, i + 1, nextMatchingIdx + 1, map, dp);
        }
        return dp[i][prev] = Math.max(take, recurse(arr, i + 1, prev, map, dp));
    }
}
