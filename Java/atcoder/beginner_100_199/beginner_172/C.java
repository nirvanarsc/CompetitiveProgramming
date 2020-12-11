package atcoder.beginner_100_199.beginner_172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int m = in.nextInt();
        final long k = in.nextLong();
        in.nextLine();
        final long[] prefixA = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixA[i + 1] = in.nextLong() + prefixA[i];
        }
        in.nextLine();
        final long[] prefixB = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefixB[i + 1] = in.nextLong() + prefixB[i];
        }
        in.nextLine();
        int res = 0;
        int j = m;
        for (int i = 0; i <= n; i++) {
            final long curr = k - prefixA[i];
            if (curr < 0) {
                break;
            }
            while (j > 0 && prefixB[j] > k - prefixA[i]) {
                j--;
            }
            res = Math.max(res, i + j);
        }
        System.out.println(res);
    }
}
