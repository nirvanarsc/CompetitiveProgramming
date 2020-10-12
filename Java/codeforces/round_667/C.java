package codeforces.round_667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int jj = 0; jj < t; jj++) {
            final int n = fs.nextInt();
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final int diff = y - x;
            int minMax = (int) 1e9;
            int bestDiff = -1;
            for (int i = 1; i <= diff; i++) {
                if (diff % i == 0) {
                    final int d = diff / i;
                    if (d + 1 == n) {
                        final int elem = x + (n - 1) * i;
                        if (minMax > elem) {
                            minMax = elem;
                            bestDiff = i;
                        }
                    } else if (d + 1 < n) {
                        int currX = x;
                        int currN = n;
                        currN -= d + 1;
                        while (currN > 0 && currX - i > 0) {
                            currN--;
                            currX -= i;
                        }
                        final int elem = currX + (n - 1) * i;
                        if (minMax > elem) {
                            minMax = elem;
                            bestDiff = i;
                        }
                    }
                }
            }
            final List<Integer> sb = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb.add(minMax);
                minMax -= bestDiff;
            }
            Collections.reverse(sb);
            for (int i = 0; i < n; i++) {
                System.out.print(sb.get(i) + " ");
            }
            System.out.println();
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
