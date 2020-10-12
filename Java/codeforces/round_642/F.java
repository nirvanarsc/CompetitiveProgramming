package codeforces.round_642;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            long[][] grid = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextLong();
                }
                in.nextLine();
            }
            System.out.println(dfs(grid, 0, 0, grid[0][0]));
//            if (n > 1) {
//                System.out.println(Math.abs(grid[0][0] - grid[1][0]) + dfs(grid, 0, 0, grid[1][0] - 1));
//            }
//            if (m > 1) {
//                System.out.println(Math.abs(grid[0][0] - grid[0][1]) + dfs(grid, 0, 0, grid[0][1] - 1));
//            }
        }
    }

    private static long dfs(long[][] grid, int i, int j, long prev) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 0;
        }

        long down = Long.MAX_VALUE;
        if (i < grid.length - 1) {
            if (prev + 1 < grid[i + 1][j]) {
                down = Math.min(down, grid[i + 1][j] - prev - 1 + dfs(grid, i + 1, j, prev + 1));
            } else {
                down = Math.min(down, prev - grid[i + 1][j] + 1) + dfs(grid, i + 1, j, grid[i + 1][j]);
            }
        }
        long right = Long.MAX_VALUE;
        if (j < grid[0].length - 1) {
            if (prev + 1 < grid[i][j + 1]) {
                right = Math.min(right, grid[i][j + 1] - prev - 1 + dfs(grid, i, j + 1, prev + 1));
            } else {
                right = Math.min(right, prev - grid[i][j + 1] + 1) + dfs(grid, i, j + 1, grid[i][j + 1]);
            }
        }

        return Math.min(down, right);
    }
}
