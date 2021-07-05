package atcoder.beginner_200_299.abc_208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    static long res;
    static long[] f;
    static int limit;
    static long prevP = 1L;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        f = new long[19];
        f[0] = f[1] = 1L;
        for (int i = 2; i < 19; i++) {
            f[i] = f[i - 1] * i;
        }
        long ans = 0;
        final char[] n = fs.next().toCharArray();
        limit = fs.nextInt();
        for (int i = 0; i < n.length - 1; i++) {
            final int flag = n[i + 1] != '0' ? 1 : 0;
            prevP *= n[i] - '0';
            dfs(n.length - i - 1, n.length - i - 1, 0, 10, new ArrayList<>());
            ans += res * (n[i] - '0' + flag);
            if (flag == 1) {
                break;
            }
            res = 0;
        }
        System.out.println(ans);
    }

    private static void dfs(int total, int n, int idx, int k, List<int[]> list) {
        if (idx == k) {
            long prod = 1L;
            long curr = f[total];
            for (int[] p : list) {
                curr /= f[p[0]];
                prod *= Math.pow(p[1], p[0]);
            }
            if (prevP * prod <= limit) {
                res += curr;
            }
            return;
        }
        if (idx == k - 1) {
            list.add(new int[] { n, idx });
            dfs(total, 0, idx + 1, k, list);
            list.remove(list.size() - 1);
        } else {
            for (int i = 0; i <= n; i++) {
                list.add(new int[] { i, idx });
                dfs(total, n - i, idx + 1, k, list);
                list.remove(list.size() - 1);
            }
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
