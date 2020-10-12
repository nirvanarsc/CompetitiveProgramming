package codeforces.round_639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            in.nextLine();
            int res = 0;
            while (n > 0) {
                int lo = 0;
                int hi = n;
                while (lo < hi) {
                    final long mid = lo + hi >>> 1;
                    final long val = (3 * mid * mid + mid) / 2;
                    if (val <= n) {
                        lo = (int) (mid + 1);
                    } else {
                        hi = (int) mid;
                    }
                }
                lo--;
                if (lo == 0) {
                    break;
                }
                res++;
                n -= (3 * lo * lo + lo) / 2;
            }
            System.out.println(res);
        }
    }
}
