package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_1130 {

    public int mctFromLeafValues(int[] arr) {
        final int n = arr.length;
        final int[][] dp = new int[n][n];
        final int[][] max = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            int localMax = 0;
            for (int j = i; j < arr.length; j++) {
                localMax = Math.max(localMax, arr[j]);
                max[i][j] = localMax;
            }
        }
        for (int l = 1; l < n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                final int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int mctFromLeafValuesGreedy(int[] arr) {
        int res = 0;
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singletonList(Integer.MAX_VALUE));
        for (int num : arr) {
            while (stack.getFirst() <= num) {
                res += stack.removeFirst() * Math.min(stack.getFirst(), num);
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            res += stack.removeFirst() * stack.getFirst();
        }
        return res;
    }
}
