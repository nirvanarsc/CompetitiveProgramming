package leetcode.weekly_contests.weekly_215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1659 {

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        return dfs(new int[n], 0, n, m, introvertsCount, extrovertsCount, new HashMap<>());
    }

    private static int dfs(int[] state, int idx, int n, int m, int iCount, int eCount,
                           Map<String, Integer> dp) {
        if ((iCount == 0 && eCount == 0) || idx == m * n) {
            return 0;
        }
        final String key = idx + Arrays.toString(state) + iCount + eCount;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        final int r = idx / n;
        final int c = idx % n;
        int[] nextState = new int[n];
        System.arraycopy(state, 1, nextState, 0, n - 1);
        int best = dfs(nextState, idx + 1, n, m, iCount, eCount, dp);
        if (iCount != 0) {
            int newScore = 120;
            if (r > 0) {
                newScore = calScore(state[0], 1, newScore);
            }
            if (c > 0) {
                newScore = calScore(state[n - 1], 1, newScore);
            }
            nextState = new int[n];
            System.arraycopy(state, 1, nextState, 0, n - 1);
            nextState[n - 1] = 1;
            best = Math.max(best, newScore + dfs(nextState, idx + 1, n, m, iCount - 1, eCount, dp));
        }
        if (eCount != 0) {
            int newScore = 40;
            if (r > 0) {
                newScore = calScore(state[0], 2, newScore);
            }
            if (c > 0) {
                newScore = calScore(state[n - 1], 2, newScore);
            }
            nextState = new int[n];
            System.arraycopy(state, 1, nextState, 0, n - 1);
            nextState[n - 1] = 2;
            best = Math.max(best, newScore + dfs(nextState, idx + 1, n, m, iCount, eCount - 1, dp));
        }
        dp.put(key, best);
        return best;
    }

    private static int calScore(int p1, int p2, int score) {
        if (p1 == 1 && p2 == 1) {
            return score - 60;
        }
        if (p1 == 2 && p2 == 2) {
            return score + 40;
        }
        if (p1 == 1 && p2 == 2) {
            return score - 10;
        }
        if (p1 == 2 && p2 == 1) {
            return score - 10;
        }
        return score;
    }
}
