package codeforces.round_650_699.round_657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int[] a = new int[m];
            final int[] b = new int[m];
            final List<Long> al = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                al.add(((long) a[i] << 30) + b[i]);
            }
            Collections.sort(al);
            Collections.reverse(al);
            int maxB = 0;
            long ans = 0;
            final long[] sum = new long[m];
            final int[] AA = new int[m];
            for (int i = 0; i < m; i++) {
                final int A = (int) (al.get(i) >>> 30);
                final int B = (int) (al.get(i) & ((1L << 30) - 1));
                sum[i] = i == 0 ? A : A + sum[i - 1];
                AA[i] = A;

                maxB = Math.max(maxB, B);
                if (i + 1 <= n) {
                    ans = Math.max(ans, (long) maxB * (n - i - 1) + sum[i]);
                }
                int lo = -1, hi = Math.min(i - 1, n - 2);
                while (lo < hi) {
                    final int mid = (lo + hi + 1) / 2;
                    if (AA[mid] >= B) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }
                ans = Math.max(ans, (long) B * (n - lo - 2) + A + (lo < 0 ? 0 : sum[lo]));
            }
            System.out.println(ans);
        }
    }
}
