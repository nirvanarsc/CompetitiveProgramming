package codeforces.round_600_649.round_645;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] g = new int[n];
            in.nextLine();
            for (int i = 0; i < n; i++) {
                g[i] = in.nextInt();
            }
            Arrays.sort(g);
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (g[i] <= i + 1) {
                    res = Math.max(i + 1, g[i]);
                    break;
                }
            }
            System.out.println(res + 1);
        }
    }
}
