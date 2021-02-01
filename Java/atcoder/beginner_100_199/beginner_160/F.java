package atcoder.beginner_100_199.beginner_160;

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

    private static class Combinations {
        long[] factorial;
        long[] facInverse;
        long[] inverse;

        Combinations(int n) {
            final int MAX = n + 2;
            factorial = new long[MAX];
            facInverse = new long[MAX];
            inverse = new long[MAX];
            factorial[0] = factorial[1] = 1;
            facInverse[0] = facInverse[1] = 1;
            inverse[1] = 1;
            for (int i = 2; i < MAX; i++) {
                factorial[i] = factorial[i - 1] * i % MOD;
                final long inv = inverse[i] = MOD - inverse[MOD % i] * (MOD / i) % MOD;
                facInverse[i] = facInverse[i - 1] * inv % MOD;
            }
        }

        long nck(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * (facInverse[k] * facInverse[n - k] % MOD) % MOD;
        }

        // combinations with repetition
        long ncr(int n, int k) {
            return nck(n + k - 1, k);
        }

        // permutations with repetition
        long npk(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * facInverse[n - k] % MOD;
        }

        long modPow(long a, long n) {
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
    }

    private static final Combinations comb = new Combinations((int) (2e5 + 5));

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final long[] dp = new long[n];
        final int[] size = new int[n];
        dfs1(0, -1, size, dp, g);
        dfs2(0, -1, size, dp, g);
        for (int i = 0; i < n; i++) {
            System.out.println(comb.factorial[n] * dp[i] % MOD);
        }
    }

    private static void dfs1(int u, int v, int[] size, long[] dp, Map<Integer, List<Integer>> g) {
        size[u] = 1;
        dp[u] = 1;
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                dfs1(next, u, size, dp, g);
                size[u] += size[next];
                dp[u] = (dp[u] * dp[next]) % MOD;
            }
        }
        dp[u] = (dp[u] * comb.inverse[size[u]]) % MOD;
    }

    private static void dfs2(int u, int v, int[] size, long[] dp, Map<Integer, List<Integer>> g) {
        if (v != -1) {
            long res = dp[v];
            res = (res * size[u]) % MOD;
            res = (res * comb.inverse[size[0] - size[u]]) % MOD;
            dp[u] = res;
        }
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                dfs2(next, u, size, dp, g);
            }
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
