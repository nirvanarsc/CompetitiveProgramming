package codeforces.segment_trees.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class B_SparseTable {

    private static int[][][] buildSparseTable(int[][] arr, int n, int mod) {
        final int[][][] lookup = new int[n + 1][18][4];
        for (int i = 0; i < n; i++) {
            lookup[i][0] = arr[i];
        }
        for (int j = 1; j <= 18; j++) {
            for (int i = 0; (i + (1 << j)) <= n; i++) {
                lookup[i][j] = mul(lookup[i][j - 1], lookup[i + (1 << (j - 1))][j - 1], mod);
            }
        }
        return lookup;
    }

    private static int[] query(int[][][] lookup, int l, int r, int mod) {
        int[] mul = { 1, 0, 0, 1 };
        for (int j = 18; j >= 0; j--) {
            if ((1 << j) <= r - l + 1) {
                mul = mul(mul, lookup[l][j], mod);
                l += 1 << j;
            }
        }
        return mul;
    }

    private static int[] mul(int[] left, int[] right, int mod) {
        final int[] res = new int[4];
        res[0] = ((left[0] * right[0]) + (left[1] * right[2])) % mod;
        res[1] = ((left[0] * right[1]) + (left[1] * right[3])) % mod;
        res[2] = ((left[2] * right[0]) + (left[3] * right[2])) % mod;
        res[3] = ((left[2] * right[1]) + (left[3] * right[3])) % mod;
        return res;
    }

    public static void main(String[] args) throws IOException {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int mod = fs.nextInt();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt() };
        }
        final int[][][] lookup = buildSparseTable(arr, n, mod);
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            final int[] res = query(lookup, l, r, mod);
            pw.println(res[0] + " " + res[1]);
            pw.println(res[2] + " " + res[3]);
            pw.println();
        }
        pw.flush();
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
