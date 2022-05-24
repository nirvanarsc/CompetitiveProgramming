package leetcode.weekly_contests.weekly_0_99.weekly_76;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_801 {

    public int minSwap(int[] A, int[] B) {
        return dfs(A, B, -1, -1, 0, 0, new Integer[A.length][2]);
    }

    private static int dfs(int[] A, int[] B, int prevA, int prevB, int i, int swapped, Integer[][] dp) {
        if (i == A.length) {
            return 0;
        }
        if (dp[i][swapped] != null) {
            return dp[i][swapped];
        }
        int keep = (int) 1e9;
        int swap = (int) 1e9;
        if (A[i] > prevA && B[i] > prevB) {
            keep = dfs(A, B, A[i], B[i], i + 1, 0, dp);
        }
        if (A[i] > prevB && B[i] > prevA) {
            swap = dfs(A, B, B[i], A[i], i + 1, 1, dp) + 1;
        }
        return dp[i][swapped] = Math.min(keep, swap);
    }
}
