package codeforces.round_700_749.round_720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static boolean[] cut;
    static boolean[] diam;
    static int[] deg;
    static int[] par;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[][] edges = new int[n - 1][2];
            cut = new boolean[n];
            diam = new boolean[n];
            par = new int[n];
            deg = new int[n];
            for (int i = 0; i < (n - 1); i++) {
                final int u = fs.nextInt() - 1;
                final int v = fs.nextInt() - 1;
                deg[u]++;
                deg[v]++;
                edges[i] = new int[] { u, v };
            }
            final int[][] g = packG(edges, n);
            final List<int[]> res = new ArrayList<>();
            dfs(0, -1, g, res);
            sb.append(res.size());
            sb.append('\n');
            for (int[] edge : res) {
                for (int i = 0; i < 4; i++) {
                    sb.append(edge[i] + 1);
                    sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int[] dfs(int u, int p, int[][] g, List<int[]> ops) {
        int L = -1;
        int R = -1;
        final List<int[]> cuts = new ArrayList<>();
        final List<int[]> subBamboos = new ArrayList<>();
        for (int v : g[u]) {
            if (v != p) {
                if (deg[v] == 1) {
                    if (L == -1) {
                        L = v;
                    } else if (R == -1) {
                        R = v;
                    } else {
                        cuts.add(new int[] { u, v });
                        subBamboos.add(dfs(v, u, g, ops));
                    }
                } else if(deg[v] > 2) {
                    cuts.add(new int[] { u, v });
                    subBamboos.add(dfs(v, u, g, ops));
                }
            }
        }
        if (L == -1) {
            L = u;
        }
        for (int i = 0; i < cuts.size(); i++) {
            ops.add(new int[] { cuts.get(i)[0], cuts.get(i)[1], L, subBamboos.get(i)[0] });
            L = subBamboos.get(i)[1];
        }
        return new int[] { L, R };
    }

    private static int[][] packG(int[][] edges, int n) {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
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
