package atcoder.beginner_100_199.beginner_193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int k = fs.nextInt();
        // taka
        final char[] s = fs.next().toCharArray();
        // aoki
        final char[] t = fs.next().toCharArray();
        double res = 0;
        for (int i = 1; i < 10; i++) {
            outer2:
            for (int j = 1; j < 10; j++) {
                final int[] taka = new int[10];
                final int[] aoki = new int[10];
                for (int l = 0; l < 4; l++) {
                    taka[s[l] - '0']++;
                    aoki[t[l] - '0']++;
                }
                taka[i]++;
                aoki[j]++;
                for (int l = 0; l < 10; l++) {
                    if (taka[l] + aoki[l] > k) {
                        continue outer2;
                    }
                }
                long ttt = 0;
                long aaa = 0;
                for (int l = 1; l < 10; l++) {
                    ttt += l * (long) Math.pow(10, taka[l]);
                    aaa += l * (long) Math.pow(10, aoki[l]);
                }
                if (ttt > aaa) {
                    taka[i]--;
                    aoki[j]--;
                    final double currT = (k - (taka[i] + aoki[i])) / (double) (9 * k - 8);
                    final double currA = (k - (taka[j] + aoki[j] + (i == j ? 1 : 0))) / (double) (9 * k - 9);
                    res += currT * currA;
                }
            }
        }
        System.out.printf("%.6f\n", res);
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
