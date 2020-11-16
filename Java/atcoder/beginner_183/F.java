package atcoder.beginner_183;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

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
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] arr = new int[n];
        final UnionFind uf = new UnionFind(n);
        final List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt() - 1;
            final Map<Integer, Integer> map = new HashMap<>();
            map.merge(arr[i], 1, Integer::sum);
            list.add(map);
        }
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int a = fs.nextInt() - 1;
                final int b = fs.nextInt() - 1;
                final int parA = uf.find(a);
                final int parB = uf.find(b);
                if (parA != parB) {
                    if (uf.size[parA] > uf.size[parB]) {
                        final Map<Integer, Integer> mergeInto = list.get(parA);
                        final Map<Integer, Integer> mergeFrom = list.get(parB);
                        for (Map.Entry<Integer, Integer> e : mergeFrom.entrySet()) {
                            mergeInto.merge(e.getKey(), e.getValue(), Integer::sum);
                        }
                    } else {
                        final Map<Integer, Integer> mergeInto = list.get(parB);
                        final Map<Integer, Integer> mergeFrom = list.get(parA);
                        for (Map.Entry<Integer, Integer> e : mergeFrom.entrySet()) {
                            mergeInto.merge(e.getKey(), e.getValue(), Integer::sum);
                        }
                    }
                    uf.union(a, b);
                }
            } else {
                final int group = fs.nextInt() - 1;
                final int key = fs.nextInt() - 1;
                final int parent = uf.find(group);
                pw.println(list.get(parent).getOrDefault(key, 0));
            }
        }
        pw.close();
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
