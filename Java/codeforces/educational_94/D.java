package codeforces.educational_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = fs.nextInt();
            final int[] arr = fs.readArray(n);
            long res = 0;
            final int[] lCounts = new int[n + 100];
            for (int l = 0; l < n; l++) {
                final int[] rCounts = new int[n + 100];
                for (int r = n - 1; r > l; r--) {
                    res += lCounts[arr[r]] * rCounts[arr[l]];
                    rCounts[arr[r]]++;
                }
                lCounts[arr[l]]++;
            }
            System.out.println(res);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
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

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
