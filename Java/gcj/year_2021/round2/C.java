package gcj.year_2021.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public final class C {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final List<Set<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g.add(new HashSet<>());
            }
            boolean ok = true;
            final List<Integer> curr = new ArrayList<>();
            if (arr[0] != 1) {
                ok = false;
            } else {
                curr.add(0);
                for (int i = 1; i < n; i++) {
                    if (arr[i] - arr[i - 1] > 1) {
                        ok = false;
                        break;
                    }
                    if (arr[i] == 1) {
                        g.get(i).add(curr.get(0));
                        curr.clear();
                        curr.add(i);
                    } else if (arr[i] - 1 == curr.size()) {
                        final int idx = arr[i] - 2;
                        final int u = curr.get(idx);
                        g.get(u).add(i);
                        curr.add(i);
                    } else {
                        final int idx = arr[i] - 2;
                        final int u = curr.get(idx);
                        final int v = curr.get(idx + 1);
                        g.get(u).remove(v);
                        g.get(u).add(i);
                        g.get(i).add(v);
                        curr.subList(idx + 1, curr.size()).clear();
                        curr.add(i);
                    }
                }
            }
            if (!ok) {
                System.out.println("Case #" + test + ": " + 0);
                continue;
            } else {
                final int[] size = new int[n];
                dfs(g, curr.get(0), size);
                long up = 1L;
                long down = 1L;
                for (int i = 0; i < n; i++) {
                    up = (up * (i + 1)) % MOD;
                    down = (down * size[i]) % MOD;
                }
                final long inv = modPow(down, MOD - 2);
                System.out.println("Case #" + test + ": " + (up * inv) % MOD);
            }
        }
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

    private static void dfs(List<Set<Integer>> g, int u, int[] size) {
        size[u] = 1;
        for (int v : g.get(u)) {
            dfs(g, v, size);
            size[u] += size[v];
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
