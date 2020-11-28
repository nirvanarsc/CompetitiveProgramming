package codeforces.round_650_699.round_666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class C {

    private static long[] bezout(long a, long b) {
        if (b == 0) {
            return new long[] { 1, 0 };
        }
        final long[] res = bezout(b, a % b);
        return new long[] { res[1], res[0] - a / b * res[1] };
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] arr = fs.nextLongArray(n);
        if (n == 1) {
            System.out.println(1 + " " + 1);
            System.out.println(arr[0]);
            System.out.println(1 + " " + 1);
            System.out.println(-arr[0]);
            System.out.println(1 + " " + 1);
            System.out.println(-arr[0]);
        } else {
            final long[] pr = bezout(n, n - 1);
            final long u = pr[0];
            final long v = pr[1];
            System.out.println(1 + " " + n);
            for (int i = 0; i < n; i++) {
                System.out.print(-u * n * arr[i] + " ");
            }
            System.out.println();
            System.out.println(2 + " " + n);
            for (int i = 1; i < n; i++) {
                System.out.print(-v * (n - 1) * arr[i] + " ");
            }
            System.out.println();
            System.out.println(1 + " " + 1);
            System.out.println(-v * (n - 1) * arr[0]);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
