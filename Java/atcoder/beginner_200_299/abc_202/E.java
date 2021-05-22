package atcoder.beginner_200_299.abc_202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] in;
    static int[] out;
    static Map<Integer, List<Integer>> dMap;
    static int time;

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        final FastScanner fs = new FastScanner();
        n = fs.nextInt();
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { i, fs.nextInt() - 1 };
        }
        g = packG();
        in = new int[n];
        out = new int[n];
        dMap = new HashMap<>();
        dfs(0, -1, 0);
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int d = fs.nextInt();
            final List<Integer> depths = dMap.get(d);
            if (depths == null) {
                sb.append(0);
                sb.append('\n');
                continue;
            }
            sb.append(lowerBound(depths, out[u]) - lowerBound(depths, in[u]));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int lowerBound(List<Integer> arr, int target) {
        int lo = 0;
        int hi = arr.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (in[arr.get(mid)] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static void dfs(int u, int p, int d) {
        in[u] = time++;
        for (int next : g[u]) {
            if (next != p) {
                dfs(next, u, d + 1);
            }
        }
        out[u] = time++;
        dMap.computeIfAbsent(d, val -> new ArrayList<>()).add(u);
    }

    private static int[][] packG() {
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
