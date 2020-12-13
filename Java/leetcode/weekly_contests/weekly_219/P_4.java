package leetcode.weekly_contests.weekly_219;

import java.util.Arrays;

public class P_4 {

    public int maxHeight(int[][] cuboids) {
        for (int[] cc : cuboids) {
            Arrays.sort(cc);
        }
        Arrays.sort(cuboids, (a, b) -> Integer.compare(b[0], a[0]));
        return dfs(cuboids, 0, 105, 105, 105, new Integer[cuboids.length][110][110][110]);
    }

    private static int dfs(int[][] arr, int idx, int prevW, int prevL, int prevH, Integer[][][][] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if(dp[idx][prevW][prevL][prevH] != null) {
            return dp[idx][prevW][prevL][prevH];
        }
        int res = dfs(arr, idx + 1, prevW, prevL, prevH, dp);
        if (arr[idx][0] <= prevW && arr[idx][1] <= prevL && arr[idx][2] <= prevH) {
            res = Math.max(res, arr[idx][2] + dfs(arr, idx + 1, arr[idx][0], arr[idx][1], arr[idx][2], dp));
        }
        return dp[idx][prevW][prevL][prevH] = res;
    }

}
