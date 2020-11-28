package codeforces.round_650_699.round_666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] arr = fs.nextLongArray(n);
        Arrays.sort(arr);
        long minD = (long) 1e18;
        if (n <= 64) {
            for (int c = 1; true; c++) {
                final long curr = f(arr, c);
                if (minD > curr) {
                    minD = curr;
                } else {
                    break;
                }
            }
            System.out.println(minD);
        } else {
            System.out.println(f(arr, 1));
        }
    }

    private static long f(long[] arr, long c) {
        long res = 0;
        long curr = 1;
        for (long l : arr) {
            res += Math.abs(l - curr);
            curr *= c;
        }
        return res;
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
