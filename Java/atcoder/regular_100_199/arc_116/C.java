package atcoder.regular_100_199.arc_116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import utils.DataStructures.TreeNode;

public final class C {

    int idx;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        final List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, res) ? res : Collections.singletonList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage, List<Integer> res) {
        if (idx == voyage.length) {
            return true;
        }
        final int val = voyage[idx];
        if (root == null || root.val != val) {
            return false;
        }
        idx++;
        if (dfs(root.left, voyage, res) && dfs(root.right, voyage, res)) {
            return true;
        }
        res.add(val);
        return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
    }

    private static final int MOD = 998244353;

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

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Combinations comb = new Combinations(n + m);
        final int[] sieve = sieveOfEratosthenes(m);
        long res = 0;
        for (int i = 1; i <= m; i++) {
            int x = i;
            long curr = 1;
            while (x > 1) {
                int count = 0;
                final int f = sieve[x];
                while (x % f == 0) {
                    x /= f;
                    count++;
                }
                curr = (curr * comb.ncr(n, count)) % MOD;
            }
            res = (res + curr) % MOD;
        }
        System.out.println(res);
    }

    private static int[] sieveOfEratosthenes(int n) {
        final int[] smallestDiv = new int[n + 1];
        for (int p = 2; p <= n; p++) {
            if (smallestDiv[p] == 0) {
                for (int i = p; i <= n; i += p) {
                    if (smallestDiv[i] == 0) {
                        smallestDiv[i] = p;
                    }
                }
                smallestDiv[p] = p;
            }
        }
        return smallestDiv;
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
