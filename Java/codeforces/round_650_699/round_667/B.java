package codeforces.round_650_699.round_667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("SuspiciousNameCombination")
public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int jj = 0; jj < t; jj++) {
            final long a = fs.nextLong();
            final long b = fs.nextLong();
            final long x = fs.nextLong();
            final long y = fs.nextLong();
            final long n = fs.nextLong();
            final long res1 = f(a, b, x, y, n);
            final long res2 = f(b, a, y, x, n);
            System.out.println(Math.min(res1, res2));
        }
    }

    private static long f(long a, long b, long x, long y, long n) {
        final long mid = Math.min(a - x, n);
        final long currA = a - mid;
        final long currB = b - Math.min(b - y, n - mid);
        return currA * currB;
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
