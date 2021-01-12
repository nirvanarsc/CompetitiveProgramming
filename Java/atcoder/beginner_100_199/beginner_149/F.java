package atcoder.beginner_100_199.beginner_149;

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

public final class F {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] pow2 = new int[n + 1];
        int p = 1;
        for (int i = 0; i <= n; i++) {
            pow2[i] = p;
            p = (p * 2) % MOD;
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final long[] res = { 0 };
        dfs(0, -1, n, g, res, pow2);
        System.out.println((res[0] * modPow(pow2[n], MOD - 2)) % MOD);

    }

    private static int dfs(int u, int v, int n, Map<Integer, List<Integer>> g, long[] res, int[] pow2) {
        int curr = 1;
        final List<Integer> trees = new ArrayList<>();
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                final int t = dfs(next, u, n, g, res, pow2);
                curr += t;
                trees.add(t);
            }
        }
        if (v != -1) {
            trees.add(n - curr);
        }
        long now = pow2[n - 1] - 1;
        for (int subtree : trees) {
            now = (now - (pow2[subtree] - 1) + MOD) % MOD;
        }
        res[0] = (res[0] + now) % MOD;
        return curr;
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
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
