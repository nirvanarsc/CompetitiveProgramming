package gcj.year_2020.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class Vestigium {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final int[][] matrix = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                final Set<Integer> row = new HashSet<>();
                final Set<Integer> col = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    row.add(matrix[i][j]);
                    col.add(matrix[j][i]);
                }
                r += row.size() != n ? 1 : 0;
                c += col.size() != n ? 1 : 0;
            }
            System.out.println("Case #" + x + ": " + trace + ' ' + r + ' ' + c);
        }
    }
}
