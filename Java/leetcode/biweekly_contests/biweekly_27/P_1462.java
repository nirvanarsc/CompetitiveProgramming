package leetcode.biweekly_contests.biweekly_27;

import java.util.ArrayList;
import java.util.List;

public class P_1462 {

    // Floyd-Warshall O(n^3)
    // Similar to https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/491446/
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        final boolean[][] g = new boolean[n][n];
        for (int[] p : prerequisites) {
            g[p[0]][p[1]] = true;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] |= g[i][k] & g[k][j];
                }
            }
        }
        final List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(g[q[0]][q[1]]);
        }
        return res;
    }
}
