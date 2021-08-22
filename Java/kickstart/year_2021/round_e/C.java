package kickstart.year_2021.round_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    static char[][] g;
    static boolean[][] seen;
    static Map<Integer, List<Integer>> gg;
    static int n;
    static int m;
    static int res;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            res = 0;
            n = fs.nextInt();
            m = fs.nextInt();
            seen = new boolean[n][m];
            g = new char[n][m];
            final char[][] temp = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    if ('A' <= g[i][j] && g[i][j] <= 'Z') {
                        temp[i][j] = '.';
                    } else {
                        temp[i][j] = g[i][j];
                    }
                }
            }
            gg = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == '.') {
                        int k = j;
                        while (k < m && temp[i][k] == '.') {
                            k++;
                        }
                        int u = j;
                        int v = k - 1;
                        while (u < v) {
                            final int l = i * m + u;
                            final int r = i * m + v;
                            gg.computeIfAbsent(l, val -> new ArrayList<>()).add(r);
                            gg.computeIfAbsent(r, val -> new ArrayList<>()).add(l);
                            u++;
                            v--;
                        }
                        j = k - 1;
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (temp[i][j] == '.') {
                        int k = i;
                        while (k < n && temp[k][j] == '.') {
                            k++;
                        }
                        int u = i;
                        int v = k - 1;
                        while (u < v) {
                            final int l = u * m + j;
                            final int r = v * m + j;
                            gg.computeIfAbsent(l, val -> new ArrayList<>()).add(r);
                            gg.computeIfAbsent(r, val -> new ArrayList<>()).add(l);
                            u++;
                            v--;
                        }
                        i = k - 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ('A' <= g[i][j] && g[i][j] <= 'Z') {
                        dfs(i, j, g[i][j]);
                    }
                }
            }
            System.out.println("Case #" + x + ": " + res);
            for (int i = 0; i < n; i++) {
                System.out.println(g[i]);
            }
        }
    }

    private static void dfs(int i, int j, char c) {
        if (seen[i][j]) {
            return;
        }
        seen[i][j] = true;
        if (g[i][j] == '.') {
            res++;
        }
        g[i][j] = c;
        for (int next : gg.getOrDefault(i * m + j, Collections.emptyList())) {
            dfs(next / m, next % m, c);
        }
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
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
