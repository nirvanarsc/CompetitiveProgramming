package codeforces.educational.edu_90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            long val = (long) 1e18;
            long curr = 0;
            final long grow = val;
            int dig = 0;
            while (true) {
                dig++;
                final int sum = count(curr);
                if (sum > n) {
                    break;
                }
                for (int i = 0; i <= 9; i++) {
                    int yo = 0;
                    for (long c = curr + i; c <= curr + i + k; c++) {
                        yo += count(c);
                    }
                    final int kl = n - yo;
                    if (kl >= 0 && kl % (k + 1) == 0) {
                        long bl = val(kl / (k + 1), true);
                        for (int op = 0; op < dig; op++) {
                            bl *= 10;
                        }
                        bl += curr + i;
                        val = Math.min(val, bl);
                    }
                }
                curr = (curr + 9) * 10;
            }
            System.out.println(val != grow ? val : -1);
        }
    }

    public static int count(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public static long val(long n, boolean check) {
        if (n == 0) {
            return 0;
        }
        if (check) {
            return Math.min(n, 8) + 10 * val(n - Math.min(n, 8), false);
        }
        return Math.min(n, 9) + 10 * val(n - Math.min(n, 9), false);
    }
}
