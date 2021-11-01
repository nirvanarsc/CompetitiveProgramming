package leetcode.weekly_contests.weekly_265;

import java.util.Arrays;

public class P_3 {

    static int end;
    static int n;
    static boolean[][] seen;
    static int[][] dp;

    public int minimumOperations(int[] nums, int start, int goal) {
        end = goal;
        n = nums.length;
        nums = Arrays.stream(nums)
                     .boxed()
                     .sorted((a, b) -> {
                         if (isValid(a) && isValid(b)) {
                             return Integer.compare(a, b);
                         } else {
                             return isValid(b) ? 1 : -1;
                         }
                     })
                     .mapToInt(Integer::intValue)
                     .toArray();
        seen = new boolean[n][1001];
        dp = new int[n][1001];
        final int res = dfs(nums, 0, start);
        return res == (long) 1e9 ? -1 : res;
    }

    private static int dfs(int[] arr, int idx, int curr) {
        if (curr == end) {
            return 0;
        }
        if (idx == n || !isValid(curr)) {
            return (int) 1e9;
        }
        if (seen[idx][curr]) {
            return dp[idx][curr];
        }
        int res = (int) 1e9;
        res = Math.min(res, dfs(arr, idx + 1, curr));
        res = Math.min(res, 1 + dfs(arr, idx + 1, curr ^ arr[idx]));
        if (arr[idx] != 0) {
            int j = 1;
            while (isValid(curr + (j - 1) * arr[idx])) {
                res = Math.min(res, j + dfs(arr, idx + 1, curr + j * arr[idx]));
                j++;
            }
            j = 1;
            while (isValid(curr - (j - 1) * arr[idx])) {
                res = Math.min(res, j + dfs(arr, idx + 1, curr - j * arr[idx]));
                j++;
            }
        }
        seen[idx][curr] = true;
        return dp[idx][curr] = res;
    }

    private static boolean isValid(int a) {
        return 0 <= a && a <= 1000;
    }
}
