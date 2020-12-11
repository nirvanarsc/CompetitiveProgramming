package atcoder.beginner_100_199.beginner_173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int row = in.nextInt();
        final int col = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        final char[][] g = new char[row][col];
        for (int i = 0; i < row; i++) {
            g[i] = in.nextLine().toCharArray();
        }
        int ans = 0;
        for (int mask = 0; mask < 1 << (row + col); mask++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (g[i][j] != '#') { continue; }
                    if ((mask & ((1 << i) | (1 << (row + j)))) != 0) { continue; }
                    count++;
                }
            }
            if (count == k) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
