package cses.graph_algorithms;

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

public final class RoundTripII {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.get(u).add(v);
        }
        final boolean[] white = new boolean[n];
        Arrays.fill(white, true);
        final boolean[] gray = new boolean[n];
        final boolean[] black = new boolean[n];
        final Map<Integer, Integer> prev = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!black[i]) {
                prev.clear();
                final int[] last = { -1 };
                if (dfs(i, -1, white, gray, black, g, prev, last)) {
                    final List<Integer> list = new ArrayList<>();
                    int p = last[0];
                    list.add(p + 1);
                    p = prev.get(p);
                    while (p != last[0]) {
                        list.add(p + 1);
                        p = prev.get(p);
                    }
                    list.add(p + 1);
                    Collections.reverse(list);
                    System.out.println(list.size());
                    for (int num : list) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean dfs(int u, int v, boolean[] white, boolean[] gray, boolean[] black,
                               List<List<Integer>> g, Map<Integer, Integer> p, int[] last) {
        white[u] = false;
        gray[u] = true;
        p.put(u, v);
        for (int n : g.get(u)) {
            if (black[n]) {
                continue;
            }
            if (gray[n]) {
                p.put(n, u);
                last[0] = n;
                return true;
            }
            if (dfs(n, u, white, gray, black, g, p, last)) {
                return true;
            }
        }
        gray[u] = false;
        black[u] = true;
        return false;
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
