package codeforces.educational_89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int tt = 0; tt < t; tt++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int total = n + m - 1;
            final int[] a = new int[total];
            final int[] b = new int[total];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    final int x = in.nextInt();
                    if (x == 1) {
                        a[i + j]++;
                    } else {
                        b[i + j]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < total / 2; i++) {
                ans += Math.min(a[i] + a[total - i - 1], b[i] + b[total - i - 1]);
            }
            System.out.println(ans);
        }
    }
}
