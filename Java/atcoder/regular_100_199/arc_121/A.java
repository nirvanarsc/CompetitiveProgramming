package atcoder.regular_100_199.arc_121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<int[]> p = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            p.add(new int[] { fs.nextInt(), fs.nextInt(), i });
        }
        if (n < 6) {
            final List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    final int x = Math.abs(p.get(i)[0] - p.get(j)[0]);
                    final int y = Math.abs(p.get(i)[1] - p.get(j)[1]);
                    res.add(Math.max(x, y));
                }
            }
            res.sort(Comparator.reverseOrder());
            System.out.println(res.get(1));
        } else {
            final List<int[]> l = new ArrayList<>();
            final List<int[]> r = new ArrayList<>();
            p.sort(Comparator.comparingInt(a -> a[0]));
            for (int i = 0; i < 3; i++) {
                l.add(p.get(i));
                l.add(p.get(n - 1 - i));
            }
            p.sort(Comparator.comparingInt(a -> a[1]));
            for (int i = 0; i < 3; i++) {
                r.add(p.get(i));
                r.add(p.get(n - 1 - i));
            }
            final List<Integer> res = new ArrayList<>();
            final Set<String> seen = new HashSet<>();
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    final int x = Math.abs(l.get(i)[0] - l.get(j)[0]);
                    final int y = Math.abs(l.get(i)[1] - l.get(j)[1]);
                    final int[] keys = { l.get(i)[2], l.get(j)[2] };
                    Arrays.sort(keys);
                    if (seen.add(keys[0] + "," + keys[1])) {
                        res.add(Math.max(x, y));
                    }
                }
            }
            for (int i = 0; i < r.size(); i++) {
                for (int j = i + 1; j < r.size(); j++) {
                    final int x = Math.abs(r.get(i)[0] - r.get(j)[0]);
                    final int y = Math.abs(r.get(i)[1] - r.get(j)[1]);
                    final int[] keys = { r.get(i)[2], r.get(j)[2] };
                    Arrays.sort(keys);
                    if (seen.add(keys[0] + "," + keys[1])) {
                        res.add(Math.max(x, y));
                    }
                }
            }
            res.sort(Comparator.reverseOrder());
            System.out.println(res.get(1));
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
