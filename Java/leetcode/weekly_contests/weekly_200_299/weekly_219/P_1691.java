package leetcode.weekly_contests.weekly_200_299.weekly_219;

import java.util.Arrays;

public class P_1691 {

    public int maxHeight(int[][] cuboids) {
        for (int[] cube : cuboids) {
            Arrays.sort(cube);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] == b[0] ?
                                       a[1] == b[1] ? Integer.compare(b[2], a[2])
                                                    : Integer.compare(b[1], a[1])
                                                    : Integer.compare(b[0], a[0]));
        return dfs(cuboids, 0, -1, new Integer[cuboids.length][cuboids.length]);
    }

    private static int dfs(int[][] arr, int idx, int prev, Integer[][] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if (prev != -1 && dp[idx][prev] != null) {
            return dp[idx][prev];
        }
        int res = dfs(arr, idx + 1, prev, dp);
        if (prev == -1
            || arr[idx][0] <= arr[prev][0] && arr[idx][1] <= arr[prev][1] && arr[idx][2] <= arr[prev][2]) {
            res = Math.max(res, arr[idx][2] + dfs(arr, idx + 1, idx, dp));
        }
        if (prev != -1) {
            dp[idx][prev] = res;
        }
        return res;
    }
}
