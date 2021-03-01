package codeforces.global_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    static int[] fibIdx;
    static int[] fib;
    static int cut;
    static boolean[] rem;

    public static void main(String[] args) throws IOException {
        final FastScanner sc = new FastScanner();
        final int n = sc.nextInt();
        final List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        final int[] size = new int[n];
        final int[] parent = new int[n];
        for (int i = 0; i < n - 1; i++) {
            final int u = sc.nextInt() - 1;
            final int v = sc.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        fillFib(n);
        dfs(0, -1, g, size, parent);
        rem = new boolean[n];
        System.out.println(f(0, -1, g, size, parent) ? "YES" : "NO");
    }

    private static void dfs(int u, int p, List<List<Integer>> g, int[] size, int[] parent) {
        size[u] = 1;
        parent[u] = p;
        for (int v : g.get(u)) {
            if (v != p) {
                dfs(v, u, g, size, parent);
                size[u] += size[v];
            }
        }
    }

    private static boolean f(int u, int p, List<List<Integer>> g, int[] size, int[] parent) {
        if (size[u] <= 2) {
            return true;
        }
        if (fibIdx[size[u]] == 0) {
            return false;
        }
        final int a = fib[fibIdx[size[u]] -1];
        final int b = a == 1 ? 1 : fib[fibIdx[size[u]] - 2];
        cut = -1;
        findCut(u, p, a, b, g, size);
        if (cut == -1) {
            return false;
        }
        int par = parent[cut];
        size[par] -= size[cut];
        while (par != u) {
            par = parent[par];
            size[par] -= size[cut];
        }
        rem[cut] = true;
        return f(cut, parent[cut], g, size, parent) && f(u, p, g, size, parent);
    }

    private static void findCut(int u, int p, int a, int b, List<List<Integer>> g, int[] size) {
        if (cut != -1) {
            return;
        }
        for (int v : g.get(u)) {
            if (rem[v] || v == p) {
                continue;
            }
            if (size[v] == a || size[v] == b) {
                cut = v;
                return;
            }
            findCut(v, u, a, b, g, size);
        }
    }

    private static void fillFib(int n) {
        fibIdx = new int[(int) 2e5];
        fib = new int[n + 1];
        int a = 1, b = 1;
        fib[1] = 1;
        fibIdx[1] = 1;
        int idx = 2;
        while (true) {
            if ((long) (a + b) > n) {
                return;
            }
            final int c = a + b;
            fib[idx] = c;
            fibIdx[c] = idx++;
            a = b;
            b = c;
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
