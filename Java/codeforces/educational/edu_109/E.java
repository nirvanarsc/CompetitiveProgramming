package codeforces.educational.edu_109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class E {

    static Set<Integer>[][] sets;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = fs.nextIntArray(m);
        }
        sets = new Set[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sets[i][j] = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    if (g[i][k] <= (j + 1)) {
                        sets[i][j].add(k);
                    }
                }
            }
        }
    }

//    private static long dfs(int n, int idx, int mask, Set<Integer> curr) {
//        if(idx == n) {
//            return curr.size();
//        }
//        long res = 0;
//        for (int i = 0; i < n; i++) {
//            if((mask & (1 << idx))== 0) {
//                if(curr.size() > sets[i][idx].size()) {
//                    curr.addAll(sets[i][idx]);
//                    res += dfs(n, idx + 1, mask | (1 << idx), curr);
//                    curr.removeAll(sets[i][idx]);
//                }
//
//            }
//        }
//
//
//    }

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
