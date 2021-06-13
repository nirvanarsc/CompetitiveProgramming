package leetcode.biweekly_contests.biweekly_54;

import java.util.HashSet;
import java.util.Set;

public class P_3 {

    public int largestMagicSquare(int[][] grid) {
        int max = 1;
        final int n = grid.length;
        final int m = grid[0].length;
        for (int L = 2; L <= 50; L++) {
            for (int i = 0; i <= n - L; i++) {
                for (int j = 0; j <= m - L; j++) {
                    if (isMagic(grid, i, j, L)) {
                        max = Math.max(max, L);
                    }
                }
            }
        }
        return max;
    }

    private static boolean isMagic(int[][] g, int i, int j, int l) {
        final int[][] curr = new int[l][l];
        for (int k = i, x = 0; k < i + l; k++, x++) {
            for (int m = j, y = 0; m < j + l; m++, y++) {
                curr[x][y] = g[k][m];
            }
        }
        return isMagicSquare(curr, l);
    }

    private static boolean isMagicSquare(int[][] grid, int n) {
        final Set<Integer> sum = new HashSet<>();
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < n; i++) {
            diag1 += grid[i][i];
            diag2 += grid[i][n - 1 - i];
        }
        sum.add(diag1);
        sum.add(diag2);
        for (int i = 0; i < n; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
                colSum += grid[j][i];
            }
            sum.add(rowSum);
            sum.add(colSum);
        }
        return sum.size() == 1;
    }
}
