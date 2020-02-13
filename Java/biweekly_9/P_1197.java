package biweekly_9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_1197 {

    private static final int[] DIRS = { 2, 1, 2, -1, 2, -1, -2, 1, 2 };
    private static final int MOD = 601;

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        final Set<Integer> seen = new HashSet<>(q);
        for (int steps = 0; !q.isEmpty(); steps++) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                final int i = curr / MOD;
                final int j = curr % MOD;
                if (i == x && j == y) { return steps; }
                for (int k = 0; k < DIRS.length - 1; k++) {
                    final int r = i + DIRS[k];
                    final int c = j + DIRS[k + 1];
                    if (r >= -2 && c >= -2 && seen.add(r * MOD + c)) {
                        q.offer(r * MOD + c);
                    }
                }
            }
        }
        return -1;
    }

    public int minKnightMovesDFS(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        return dfs(x, y, new Integer[x + 3][y + 3]);
    }

    int dfs(int x, int y, Integer[][] dp) {
        if (x + y == 0) {
            return 0;
        }
        if (x + y == 2) {
            return 2;
        }
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        return dp[x][y] = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2), dp),
                                   dfs(Math.abs(x - 2), Math.abs(y - 1), dp)) + 1;
    }

    private static final int[][] localRegion = {
            { 0, 3, 2 },
            { 3, 2, 1 },
            { 2, 1, 4 }
    };

    @SuppressWarnings("SuspiciousNameCombination")
    public int minKnightMovesMath(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x < y) {
            final int tmp = x;
            x = y;
            y = tmp;
        }
        if (x <= 2) {
            return localRegion[x][y];
        }

        final int groupId;
        if ((x - 3) >= (y - 3) * 2) {
            groupId = (x - 1) / 2 + 1;
        } else {
            groupId = (x + y - 2) / 3 + 1;
        }

        return groupId + ((x + y + groupId) % 2);
    }
}
