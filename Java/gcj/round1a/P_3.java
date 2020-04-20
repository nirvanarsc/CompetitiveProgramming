package gcj.round1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class P_3 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int[][] matrix = new int[n][m];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                    sum += matrix[i][j];
                }
            }
            long res = 0;
            while (true) {
                final List<int[]> eliminated = new ArrayList<>();
                long eliminationSum = 0;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] > 0) {
                            final double[] neighbourSum = neighbourSum(matrix, i, j);
                            if (neighbourSum[0] != 0 &&
                                Double.compare(neighbourSum[1] / neighbourSum[0], matrix[i][j]) > 0) {
                                eliminated.add(new int[] { i, j });
                                eliminationSum += matrix[i][j];
                            }
                        }
                    }
                }
                res += sum;
                sum -= eliminationSum;
                if (eliminationSum == 0) {
                    break;
                }
                for (int[] e : eliminated) {
                    matrix[e[0]][e[1]] = 0;
                }
            }
            System.out.println("Case #" + x + ": " + res);
        }
    }

    private static double[] neighbourSum(int[][] grid, int r, int c) {
        double neighbours = 0;
        double neighboursSum = 0;
        final int t = grid[r][c];
        grid[r][c] = 0;
        for (int[] dir : DIRS) {
            int currR = r;
            int currC = c;
            while (currR >= 0 && currR < grid.length && currC >= 0 && currC < grid[0].length
                   && grid[currR][currC] == 0) {
                currR += dir[0];
                currC += dir[1];
            }
            if (currR >= 0 && currR < grid.length && currC >= 0 && currC < grid[0].length
                && grid[currR][currC] != 0) {
                neighbours++;
                neighboursSum += grid[currR][currC];
            }
        }
        grid[r][c] = t;
        return new double[] { neighbours, neighboursSum };
    }
}
