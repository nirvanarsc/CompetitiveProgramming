package codeforces.educational_88;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final long h = in.nextLong();
            final long c = in.nextLong();
            final long target = in.nextLong();
            in.nextLine();
            if (2 * target <= (h + c)) {
                System.out.println(2);
                continue;
            }
            if (target == h) {
                System.out.println(1);
                continue;
            }
            int lo = 1, hi = (int) 1e9, f = -1;
            while (lo <= hi) {
                final int mid = lo + hi >> 1;
                final long a = h * (mid + 1) + c * mid;
                final long b = 2 * mid + 1;
                if (a <= b * target) {
                    f = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            final long an = target * (2 * f + 1) - h * (f + 1) - c * f;
            final long ad = 2 * f + 1;

            final long bn = h * f + c * (f - 1) - target * (2 * f - 1);
            final long bd = 2 * f - 1;

            if (an * bd < bn * ad) {
                System.out.println(2 * f + 1);
            } else {
                System.out.println(2 * f - 1);
            }
        }
    }
}
