package codeforces.round_648;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        out:
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = in.next().toCharArray();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'B') {
                        for (int[] dir : DIRS) {
                            final int nX = i + dir[0];
                            final int nY = j + dir[1];
                            if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                                if (grid[nX][nY] == 'G') {
                                    System.out.println("No");
                                    continue out;
                                }
                                if (grid[nX][nY] == '.') {
                                    grid[nX][nY] = '#';
                                }
                            }
                        }
                    }
                }
            }
            dfs(grid, n - 1, m - 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'G') {
                        System.out.println("No");
                        continue out;
                    }
                }
            }
            System.out.println("Yes");
        }
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#') {
            return;
        }
        grid[i][j] = '#';
        for (int[] dir : DIRS) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
