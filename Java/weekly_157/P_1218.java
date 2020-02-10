package weekly_157;

import java.util.HashMap;
import java.util.Map;

public class P_1218 {

    public int longestSubsequenceBottomUp(int[] arr, int difference) {
        int res = 1;
        final int[] m = new int[40004];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 20000;
        }
        for (int value : arr) {
            final int d = value - difference;
            m[value] = m[d] + 1;
            res = Math.max(m[value], res);
        }
        return res;
    }

    public int longestSubsequenceHM(int[] arr, int difference) {
        final Map<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for (int value : arr) {
            dp.put(value, dp.getOrDefault(value - difference, 0) + 1);
            longest = Math.max(longest, dp.get(value));
        }
        return longest;
    }

    // Time Limit Exceeded
    public static int longestSubsequence(int[] arr, int difference) {
        final int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] + difference == arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // Memory Limit Exceeded
    public int longestSubsequenceTopDown(int[] arr, int difference) {
        return recurse(arr, -1, 0, difference, new Integer[arr.length][arr.length]);
    }

    private static int recurse(int[] arr, int prev, int i, int diff, Integer[][] dp) {
        if (i == arr.length) {
            return 0;
        }
        if (prev != -1 && dp[prev][i] != null) {
            return dp[prev][i];
        }
        int take = 0;
        if (prev < 0 || arr[prev] + diff == arr[i]) {
            take = 1 + recurse(arr, i, i + 1, diff, dp);
        }
        final int skip = recurse(arr, prev, i + 1, diff, dp);
        if (prev != -1) {
            dp[prev][i] = Math.max(take, skip);
        }
        return Math.max(skip, take);
    }
}
