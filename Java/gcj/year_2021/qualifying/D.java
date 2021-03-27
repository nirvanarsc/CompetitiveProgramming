package gcj.year_2021.qualifying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        for (int i = 0; i < t; i++) {
            final List<Integer> l = new ArrayList<>();
            final int m = query(1, 2, 3, fs);
            if (m == 1) {
                l.add(2);
                l.add(1);
                l.add(3);
            } else if (m == 2) {
                l.add(1);
                l.add(2);
                l.add(3);
            } else {
                l.add(1);
                l.add(3);
                l.add(2);
            }
            int next = 4;
            int last = -1;
            while (l.size() < n) {
                int lo = 0, hi = l.size() - 1;
                while (lo < hi) {
                    final int mid = lo + hi + 1 >>> 1;
                    if (mid == l.size() - 1) {
                        lo = l.size() - 1;
                        break;
                    }
                    last = query(l.get(l.size() - 1), l.get(mid), next, fs);
                    if (last == l.get(mid)) {
                        hi = mid - 1;
                    } else {
                        lo = mid;
                    }

                }
                if (lo == l.size() - 1) {
                    if (last == l.get(l.size() - 1)) {
                        l.add(next);
                    } else {
                        l.add(l.size() - 1, next);
                    }
                } else {
                    last = query(l.get(l.size() - 1), l.get(lo), next, fs);
                    if (last == l.get(lo)) {
                        l.add(lo, next);
                    } else {
                        l.add(lo + 1, next);
                    }
                }
                next++;
            }
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(l.get(j));
                sb.append(' ');
            }
            System.out.println(sb);
            System.out.flush();
            final int ans = fs.nextInt();
            if (ans != 1) {
                System.exit(1);
            }
        }
        System.out.flush();
    }

    private static int query(int x, int y, int z, FastScanner fs) {
        System.out.println(x + " " + y + ' ' + z);
        System.out.flush();
        return fs.nextInt();
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
