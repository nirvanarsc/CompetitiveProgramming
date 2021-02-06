package codeforces.round_650_699.round_699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final char[][] g = new char[n][n];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            int sameL = -1;
            int sameR = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && g[i][j] == g[j][i]) {
                        sameL = i + 1;
                        sameR = j + 1;
                    }
                }
            }
            if (m % 2 != 0) {
                sameL = 1;
                sameR = 2;
            }
            if (sameL != -1 && sameR != -1) {
                final StringBuilder sb = new StringBuilder();
                boolean turn = true;
                for (int i = 0; i <= m; i++) {
                    sb.append(turn ? sameR : sameL);
                    sb.append(' ');
                    turn ^= true;
                }
                System.out.println("YES");
                System.out.println(sb);
                continue;
            }
            int a = -1;
            int b = -1;
            int c = -1;
            for (int i = 0; i < n; i++) {
                int l = -1;
                int r = -1;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (g[i][j] == 'a') {
                            l = j;
                        } else if (g[i][j] == 'b') {
                            r = j;
                        }
                    }
                }
                if (l != -1 && r != -1) {
                    a = i + 1;
                    b = l + 1;
                    c = r + 1;
                    break;
                }
            }
            if (a != -1) {
                final StringBuilder sb = new StringBuilder();
                boolean turn = (m / 2) % 2 == 0;
                if (!turn) {
                    final int temp = b;
                    b = c;
                    c = temp;
                }
                for (int i = 0; i <= m / 2; i++) {
                    sb.append(turn ? a : b);
                    sb.append(' ');
                    turn ^= true;
                }
                for (int i = 0; i < m / 2; i++) {
                    sb.append(turn ? a : c);
                    sb.append(' ');
                    turn ^= true;
                }
                System.out.println("YES");
                System.out.println(sb);
                continue;
            }
            System.out.println("NO");
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        private Utils() {}
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
