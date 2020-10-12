package codeforces.round_654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            int k = in.nextInt();
            final int[][] res = new int[n][n];
            final int[] rowCount = new int[n];
            final int[] colCount = new int[n];
            int minR = Integer.MAX_VALUE;
            int maxR = Integer.MIN_VALUE;
            int minC = Integer.MAX_VALUE;
            int maxC = Integer.MIN_VALUE;
            int start = 0;
            while (k > 0) {
                int curr = start++;
                for (int i = 0; i < n && k > 0; i++, k--) {
                    res[i][curr] = 1;
                    rowCount[i]++;
                    colCount[curr]++;
                    curr = (curr + 1) % n;
                }
            }
            for (int i = 0; i < n; i++) {
                minR = Math.min(minR, rowCount[i]);
                maxR = Math.max(maxR, rowCount[i]);
                minC = Math.min(minC, colCount[i]);
                maxC = Math.max(maxC, colCount[i]);
            }
            final int rowDiff = maxR - minR;
            final int colDiff = maxC - minC;
            System.out.println(rowDiff * rowDiff + colDiff * colDiff);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j]);
                }
                System.out.println();
            }
        }
    }
}
