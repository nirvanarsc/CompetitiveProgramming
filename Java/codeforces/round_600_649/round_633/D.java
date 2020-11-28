package codeforces.round_600_649.round_633;

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
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final List<Integer> depths = new ArrayList<>();
        final int[] m = { 0 };
        final int[] l = { 0 };
        final boolean[] hasChildLeaf = new boolean[n + 1];
        dfs(g, 1, -1, 0, m, l, depths, hasChildLeaf);
        if (g.get(1).size() == 1) {
            if (isLeaf(g, 1) && !hasChildLeaf[g.get(1).get(0)]) {
                m[0]++;
            }
        }
        final boolean parity = depths.stream().allMatch(p -> p % 2 == 0) ||
                               depths.stream().allMatch(p -> p % 2 != 0);
        final int min = parity ? 1 : 3;
        final int max = n - 1 - l[0] + m[0];
        System.out.println(min + " " + max);
    }

    private static void dfs(Map<Integer, List<Integer>> g, int u, int v, int depth,
                            int[] m, int[] l, List<Integer> depths, boolean[] hasChildLeaf) {
        if (isLeaf(g, u)) {
            l[0]++;
            depths.add(depth);
        }
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                if (isLeaf(g, next)) {
                    if (!hasChildLeaf[u]) {
                        m[0]++;
                        hasChildLeaf[u] = true;
                    }
                }
                dfs(g, next, u, depth + 1, m, l, depths, hasChildLeaf);
            }
        }
    }

    private static boolean isLeaf(Map<Integer, List<Integer>> g, int u) {
        return g.get(u).size() == 1;
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
