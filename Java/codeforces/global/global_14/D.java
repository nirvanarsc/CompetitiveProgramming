package codeforces.global.global_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("ComparatorCombinators")
public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            final int[] ll = new int[n];
            final int[] rr = new int[n];
            for (int i = 0; i < l; i++) {
                ll[fs.nextInt() - 1]++;
            }
            for (int i = 0; i < r; i++) {
                rr[fs.nextInt() - 1]++;
            }
            int remL = 0;
            int remR = 0;
            for (int i = 0; i < n; i++) {
                final int min = Math.min(ll[i], rr[i]);
                ll[i] -= min;
                rr[i] -= min;
                remL += ll[i];
                remR += rr[i];
            }
            int res = 0;
            final PriorityQueue<int[]> lll = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            final PriorityQueue<int[]> rrr = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            if (remL < remR) {
                int oddR = 0;
                for (int i = 0; i < n; i++) {
                    if (rr[i] % 2 != 0) {
                        oddR++;
                        res++;
                        rr[i]--;
                    }
                }
                for (int i = 0; i < n; i++) {
                    final int min = Math.min(ll[i], oddR);
                    oddR -= min;
                    ll[i] -= min;
                }
                init(n, ll, rr, lll, rrr);
                while (!lll.isEmpty()) {
                    final int[] curr = lll.remove();
                    while (curr[0] > 0) {
                        final int[] other = rrr.remove();
                        final int min = Math.min(curr[0], other[0]);
                        curr[0] -= min;
                        other[0] -= min;
                        rr[other[1]] -= min;
                        res += min;
                        if (other[0] > 0) {
                            rrr.offer(other);
                        }
                    }
                }
                int last = 0;
                for (int i = 0; i < n; i++) {
                    res += rr[i] / 2;
                    rr[i] %= 2;
                    last += rr[i];
                }
                res += last;
            } else {
                int oddL = 0;
                for (int i = 0; i < n; i++) {
                    if (ll[i] % 2 != 0) {
                        oddL++;
                        res++;
                        ll[i]--;
                    }
                }
                for (int i = 0; i < n; i++) {
                    final int min = Math.min(rr[i], oddL);
                    oddL -= min;
                    rr[i] -= min;
                }
                init(n, ll, rr, lll, rrr);
                while (!rrr.isEmpty()) {
                    final int[] curr = rrr.remove();
                    while (curr[0] > 0) {
                        final int[] other = lll.remove();
                        final int min = Math.min(curr[0], other[0]);
                        curr[0] -= min;
                        other[0] -= min;
                        ll[other[1]] -= min;
                        res += min;
                        if (other[0] > 0) {
                            lll.offer(other);
                        }
                    }
                }
                int last = 0;
                for (int i = 0; i < n; i++) {
                    res += ll[i] / 2;
                    ll[i] %= 2;
                    last += ll[i];
                }
                res += last;
            }
            sb.append(res);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void init(int n, int[] ll, int[] rr, PriorityQueue<int[]> lll, PriorityQueue<int[]> rrr) {
        for (int i = 0; i < n; i++) {
            if (ll[i] > 0) {
                lll.add(new int[] { ll[i], i });
            }
            if (rr[i] > 0) {
                rrr.add(new int[] { rr[i], i });
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
