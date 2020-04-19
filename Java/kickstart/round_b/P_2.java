package kickstart.round_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class P_2 {

    static class Pair {
        long res;
        boolean canFinish;

        Pair(long res, boolean canFinish) {
            this.res = res;
            this.canFinish = canFinish;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final long d = in.nextLong();
            final long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            long lo = 1;
            long hi = 2 * d;
            long res = 1;
            while (lo < hi) {
                final long mid = lo + hi >>> 1;
                final Pair curr = canFinish(arr, mid, d);
                if (curr.canFinish) {
                    res = curr.res;
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            System.out.println("Case #" + x + ": " + res);
        }
    }

    private static Pair canFinish(long[] arr, long mid, long d) {
        if (mid % arr[0] != 0) {
            mid = (mid / arr[0]) * arr[0] + arr[0];
        }
        final long res = mid;
        for (int i = 1; i < arr.length; i++) {
            if (mid % arr[i] != 0) {
                mid = (mid / arr[i]) * arr[i] + arr[i];
            }
        }
        return new Pair(res, mid <= d);
    }
}
