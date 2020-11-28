package codeforces.round_650_699.round_685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            final int[] countA = new int[26];
            final int[] countB = new int[26];
            final char[] strA = fs.next().toCharArray();
            final char[] strB = fs.next().toCharArray();
            for (int i = 0; i < n; i++) {
                countA[strA[i] - 'a']++;
                countB[strB[i] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (countB[i] == 0) {
                    continue;
                }
                final int common = Math.min(countB[i], countA[i]);
                countB[i] -= common;
                countA[i] -= common;
                if (countB[i] > 0 && countB[i] % k != 0) {
                    System.out.println("No");
                    continue outer;
                }
                for (int j = 0; j < i && countB[i] > 0; j++) {
                    if (countA[j] > 0) {
                        final int minTimes = Math.min(countA[j] / k, countB[i] / k);
                        countA[j] -= minTimes * k;
                        countB[i] -= minTimes * k;
                    }
                }
                if (countB[i] > 0) {
                    System.out.println("No");
                    continue outer;
                }
            }
            System.out.println("Yes");
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
