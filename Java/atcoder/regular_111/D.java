package atcoder.regular_111;

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

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
        }
        final int[] c = fs.nextIntArray(n);
        final Map<Integer, List<int[]>> g = new HashMap<>();
        final int[] res = new int[m];
        Arrays.fill(res, -1);
        for (int i = 0; i < m; i++) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            if (c[u] < c[v]) {
                res[i] = 1;
            } else if(c[u] > c[v]) {
                res[i] = 0;
            } else if (c[u] == c[v]) {
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, i, 1 });
                g.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, i, 0 });
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, -1, g, res);
        }
        for (int i = 0; i < m; i++) {
            if (res[i] == 1) {
                System.out.println("<-");
            } else {
                System.out.println("->");
            }
        }
    }

    private static void dfs(int u, int v, Map<Integer, List<int[]>> g, int[] res) {
        for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
            if (res[next[0]] != -1) {
                continue;
            }
            res[next[1]] = next[2];
            dfs(next[0], u, g, res);
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
