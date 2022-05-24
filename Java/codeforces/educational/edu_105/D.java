package codeforces.educational.edu_105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static int getRoot(List<Integer> list, int[][] g, int[] n, List<Integer> c, List<int[]> e) {
        if (list.size() == 1) {
            return list.get(0);
        }
        int max = -1;
        for (int u : list) {
            max = Math.max(max, g[list.get(0) - 1][u - 1]);
        }
        final List<List<Integer>> tree = new ArrayList<>();
        tree.add(new ArrayList<>(Collections.singletonList(list.get(0))));
        for (int i = 1; i < list.size(); i++) {
            final int v = list.get(i);
            int group = -1;
            for (int j = 0; j < tree.size(); j++) {
                if (g[v - 1][tree.get(j).get(0) - 1] != max) {
                    group = j;
                    break;
                }
            }
            if (group == -1) {
                group = tree.size();
                tree.add(new ArrayList<>());
            }
            tree.get(group).add(v);
        }
        c.add(max);
        final int root = ++n[0];
        for (int i = 0; i < tree.size(); i++) {
            final int childRoot = getRoot(tree.get(i), g, n, c, e);
            e.add(new int[] { childRoot, root });
        }
        return root;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] g = new int[n][n];
        final List<int[]> edges = new ArrayList<>();
        final List<Integer> c = new ArrayList<>();
        final List<Integer> initial = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = fs.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            c.add(g[i][i]);
            initial.add(i + 1);
        }
        final int root = getRoot(initial, g, new int[] { n }, c, edges);
        System.out.println(c.size());
        for (int i = 0; i < c.size(); i++) {
            System.out.printf("%d ", c.get(i));
        }
        System.out.println();
        System.out.println(root);
        for (int i = 0; i < edges.size(); i++) {
            System.out.printf("%d %d\n", edges.get(i)[0], edges.get(i)[1]);
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
