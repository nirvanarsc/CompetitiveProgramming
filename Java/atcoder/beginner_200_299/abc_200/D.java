package atcoder.beginner_200_299.abc_200;

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
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final int[] f = new int[200];
        final int maxBits = Math.min(n, 8);
        for (int mask = 1; mask < 1 << maxBits; mask++) {
            int curr = 0;
            for (int i = 0; i < maxBits; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr = (curr + arr[i]) % 200;
                }
            }
            if (f[curr] > 0) {
                final List<Integer> l = new ArrayList<>();
                final List<Integer> r = new ArrayList<>();
                for (int i = 0; i < maxBits; i++) {
                    if ((f[curr] & (1 << i)) != 0) {
                        l.add(i);
                    }
                    if ((mask & (1 << i)) != 0) {
                        r.add(i);
                    }
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("YES\n");
                sb.append(l.size());
                sb.append(' ');
                for (int idx : l) {
                    sb.append(idx + 1);
                    sb.append(' ');
                }
                sb.append('\n');
                sb.append(r.size());
                sb.append(' ');
                for (int idx : r) {
                    sb.append(idx + 1);
                    sb.append(' ');
                }
                sb.append('\n');
                System.out.println(sb);
                return;
            } else {
                f[curr] = mask;
            }
        }
        System.out.println("NO");
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
