package codeforces.round_600_649.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class G {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int a = in.nextInt();
            final int b = in.nextInt();
            if (n * a != m * b) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            final int[][] matrix = new int[n][m];
            int x = 0;
            for (int y = 0; y < n; y++) {
                for (int wid = 0; wid < a; wid++) {
                    matrix[y][x] = 1;
                    x = (x + 1) % m;
                }
            }
            for (int j = 0; j < n; j++) {
                final StringBuilder sb = new StringBuilder();
                for (int k = 0; k < m; k++) {
                    sb.append(matrix[j][k]);
                }
                System.out.println(sb);
            }
        }
    }
}
