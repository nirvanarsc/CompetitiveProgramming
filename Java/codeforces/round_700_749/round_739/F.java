package codeforces.round_700_749.round_739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        final List<Long> l1 = new ArrayList<>();
        final List<Long> l2 = new ArrayList<>();
        for (int d = 1; d < 10; d++) {
            long curr = d;
            for (int i = 0; i < 11; i++) {
                l1.add(curr);
                curr = curr * 10 + d;
            }
        }
        for (int d1 = 0; d1 < 10; d1++) {
            for (int d2 = 0; d2 < 10; d2++) {
                for (int L = 0; L < 11; L++) {
                    for (int mask = 0; mask < (1 << L); mask++) {
                        long curr = 0;
                        for (int i = 0; i < L; i++) {
                            curr *= 10;
                            if ((mask & (1 << i)) != 0) {
                                curr += d1;
                            } else {
                                curr += d2;
                            }
                        }
                        l2.add(curr);
                    }
                }
            }
        }
        l1.sort(Comparator.naturalOrder());
        l2.sort(Comparator.naturalOrder());
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            long res = l1.get(lowerBound(l1, n));
            if (k == 2) {
                res = Math.min(res, l2.get(lowerBound(l2, n)));
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    private static int lowerBound(List<Long> list, long target) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
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
