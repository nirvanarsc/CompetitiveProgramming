package codeforces.round_600_649.round_649;

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

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        final UnionFind uf = new UnionFind(k);
        final Map<Integer, List<Integer>> g = new HashMap<>();
        int first = -1;
        int last = -1;
        boolean cycle = false;
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            if (u < k && v < k) {
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
                if (uf.find(u) == uf.find(v)) {
                    cycle = true;
                    first = u;
                    last = v;
                    break;
                } else {
                    uf.union(u, v);
                }
            }
        }
        if (cycle) {
            final boolean[] seen = new boolean[k];
            final int[] par = new int[k];
            dfs1(first, -1, seen, par, g);
            par[first] = last;
            final List<Integer> res = new ArrayList<>();
            while (last != first) {
                res.add(last);
                last = par[last];
            }
            res.add(last);
            System.out.println(2);
            System.out.println(res.size());
            printList(res);
        } else {
            final List<Integer> even = new ArrayList<>();
            final List<Integer> odd = new ArrayList<>();
            final boolean[] seen = new boolean[k];
            for (int i = 0; i < k; i++) {
                dfs2(i, seen, g, even, odd, 0);
            }
            final List<Integer> res = even.size() > odd.size() ? even : odd;
            System.out.println(1);
            printList(res.subList(0, (k + 1) / 2));
        }
    }

    private static void printList(List<Integer> res) {
        for (int num : res) {
            System.out.print((num + 1) + " ");
        }
        System.out.println();
    }

    private static void dfs1(int curr, int par, boolean[] seen, int[] parents, Map<Integer, List<Integer>> g) {
        if (seen[curr]) {
            return;
        }
        parents[curr] = par;
        seen[curr] = true;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            if (next != par) {
                dfs1(next, curr, seen, parents, g);
            }
        }
    }

    private static void dfs2(int curr, boolean[] seen, Map<Integer, List<Integer>> g,
                             List<Integer> even, List<Integer> odd, int d) {
        if (seen[curr]) {
            return;
        }
        if (d % 2 == 0) {
            even.add(curr);
        } else {
            odd.add(curr);
        }
        seen[curr] = true;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            dfs2(next, seen, g, even, odd, d + 1);
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
