package leetcode.weekly_contests.weekly_44;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_656 {

    public List<Integer> cheapestJump(int[] A, int B) {
        final Integer[] next = new Integer[A.length];
        dfs(A, B, 0, next, new Integer[A.length]);
        final List<Integer> path = new ArrayList<>(Collections.singleton(1));
        for (int i = 0; i < A.length && next[i] != null; i = next[i]) {
            path.add(next[i] + 1);
        }
        return path.get(path.size() - 1) == A.length ? path : new ArrayList<>();
    }

    private static int dfs(int[] A, int B, int start, Integer[] next, Integer[] memo) {
        if (memo[start] != null) {
            return memo[start];
        }
        if (start == A.length - 1) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 1; i <= B; i++) {
            if (start + i < A.length && A[start + i] != -1) {
                final int temp = dfs(A, B, start + i, next, memo);
                if (temp < minCost) {
                    minCost = temp;
                    minIdx = start + i;
                }
            }
        }
        if (minIdx != -1) {
            next[start] = minIdx;
        }
        return memo[start] = A[start] + minCost;
    }
}
