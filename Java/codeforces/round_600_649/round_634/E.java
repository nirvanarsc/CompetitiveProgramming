package codeforces.round_600_649.round_634;

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

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final Map<Integer, List<Integer>> indices = new HashMap<>();
            final int[][] preSum = new int[200][n];
            for (int i = 0; i < n; i++) {
                final int curr = arr[i];
                indices.computeIfAbsent(curr, val -> new ArrayList<>()).add(i);
            }
            for (int i = 1; i <= 200; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    count += arr[j] == i ? 1 : 0;
                    preSum[i - 1][j] = count;
                }
            }
            int res = 0;
            for (int i = 1; i <= 200; i++) {
                final List<Integer> curr = indices.getOrDefault(i, Collections.emptyList());
                res = Math.max(res, curr.size());
                if (curr.size() <= 1) {
                    continue;
                }
                for (int side = 1; side * 2 <= curr.size(); side++) {
                    final int l = curr.get(side - 1);
                    final int r = curr.get(curr.size() - side);
                    for (int j = 0; j < 200; j++) {
                        if (j + 1 != i) {
                            final int mid = preSum[j][r] - preSum[j][l];
                            res = Math.max(res, 2 * side + mid);
                        }
                    }
                }
            }
            System.out.println(res);
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
