package codeforces.round_600_649.round_648;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
                in.nextLine();
            }
            int row = 0;
            int col = 0;
            for (int i = 0; i < n; i++) {
                boolean emptyRow = true;
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        emptyRow = false;
                        break;
                    }
                }
                if (emptyRow) {
                    row++;
                }
            }
            for (int j = 0; j < m; j++) {
                boolean emptyCol = true;
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == 1) {
                        emptyCol = false;
                        break;
                    }
                }
                if (emptyCol) {
                    col++;
                }
            }
            System.out.println(Math.min(row, col) % 2 == 0 ? "Vivek" : "Ashish");
        }
    }
}
