package codeforces.round_700_749.round_731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class G {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] color;
    static int[][] c;
    static List<Integer>[] s = new ArrayList[2];

    private static void dfs(int u, int[] color, boolean useS) {
        color[u] = 1;
        for (int v : g[u]) {
            if (color[v] == 0) {
                dfs(v, color, useS);
            } else if (useS) {
                s[color[v] - 1].add(v);
            }
        }
        color[u] = 2;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            n = fs.nextInt();
            final int m = fs.nextInt();
            edges = new int[m][2];
            s[0] = new ArrayList<>();
            s[1] = new ArrayList<>();
            color = new int[n];
            c = new int[2][n];
            for (int i = 0; i < m; i++) {
                edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
            }
            g = packG();
            dfs(0, color, true);
            for (int i = 0; i < 2; i++) {
                for (int u : s[i]) {
                    dfs(u, c[i], false);
                }
            }
            for (int i = 0; i < n; i++) {
                int res = 0;
                if (color[i] != 0) {
                    res = 1;
                    if (c[0][i] > 0) {
                        res = -1;
                    } else if (c[1][i] > 0) {
                        res = 2;
                    }
                }
                sb.append(res).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
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
