package weekly_166;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class LightsOutMinMoves {

    public static int minFlips(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final int ans = func(mat, n, m, new HashSet<>(), new HashMap<>());
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int func(int[][] mat, int n, int m, Set<String> set, Map<String, Integer> dp) {
        if (isSolved(mat, n, m)) {
            return 0;
        }

        final StringBuilder t = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t.append(mat[i][j]);
            }
        }
        final String hash = t.toString();

        if (dp.containsKey(hash)) {
            return dp.get(hash);
        }
        if (set.contains(hash)) {
            return Integer.MAX_VALUE;
        }

        set.add(hash);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flip(mat, n, m, i, j);
                final int small = func(mat, n, m, set, dp);
                if (small != Integer.MAX_VALUE) { min = Math.min(min, 1 + small); }
                flip(mat, n, m, i, j);
            }
        }
        dp.put(hash, min);
        return min;
    }

    private static boolean isSolved(int[][] mat, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void flip(int[][] mat, int n, int m, int i, int j) {
        mat[i][j] ^= 1;
        if (i - 1 >= 0) { mat[i - 1][j] ^= 1; }
        if (i + 1 < n) { mat[i + 1][j] ^= 1; }
        if (j - 1 >= 0) { mat[i][j - 1] ^= 1; }
        if (j + 1 < m) { mat[i][j + 1] ^= 1; }
    }

    public static void main(String[] args) {
        System.out.println(minFlips(new int[][] { { 0, 0 }, { 0, 1 } }));
        System.out.println(minFlips(new int[][] { { 0 } }));
        System.out.println(minFlips(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 0, 0, 0 } }));
        System.out.println(minFlips(new int[][] { { 1, 0, 0 }, { 1, 0, 0 } }));
    }

    private LightsOutMinMoves() {}
}
