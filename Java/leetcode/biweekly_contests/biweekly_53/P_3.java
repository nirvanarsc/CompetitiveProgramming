package leetcode.biweekly_contests.biweekly_53;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P_3 {

    public int[] getBiggestThree(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(grid[i][j]);
                for (int L = 1; L <= 25; L++) {
                    final int curr = f(grid, L, i, j, n, m);
                    if (curr != (int) 1e9) {
                        set.add(curr);
                    }
                }
            }
        }
        return set.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).toArray();
    }

    private static int f(int[][] g, int size, int i, int j, int n, int m) {
        if (i + size >= n || i - size < 0 || (j + 2 * size) >= m) {
            return (int) 1e9;
        }
        int sum = 0;
        for (int k = 1; k < size; k++) {
            sum += g[i - k][j + k];
            sum += g[i + k][j + k];
            sum += g[i - k][j + 2 * size - k];
            sum += g[i + k][j + 2 * size - k];
        }
        sum += g[i][j];
        sum += g[i][j + 2 * size];
        sum += g[i + size][j + size];
        sum += g[i - size][j + size];
        return sum;
    }
}
