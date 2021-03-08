package codeforces.round_700_749.round_705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    static int[] map;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        map = new int[256];
        Arrays.fill(map, -1);
        map[0] = 0;
        map[1] = 1;
        map[8] = 8;
        map[2] = 5;
        map[5] = 2;
        for (int test = 0; test < t; test++) {
            final int h = fs.nextInt();
            final int m = fs.nextInt();
            final String[] time = fs.next().split(":");
            System.out.println(f(Integer.parseInt(time[0]), Integer.parseInt(time[1]), h, m));
        }
    }

    private static String f(int h, int m, int hh, int mm) {
        if (map[h / 10] != -1 && map[h % 10] != -1 && map[m / 10] != -1 && map[m % 10] != -1) {
            final int revM = map[h % 10] * 10 + map[h / 10];
            final int revH = map[m % 10] * 10 + map[m / 10];
            if (revH < hh && revM < mm) {
                final char[] hour = new char[2];
                final char[] min = new char[2];
                Arrays.fill(hour, '0');
                Arrays.fill(min, '0');
                hour[0] = (char) ((h / 10) + '0');
                hour[1] = (char) ((h % 10) + '0');
                min[0] = (char) ((m / 10) + '0');
                min[1] = (char) ((m % 10) + '0');
                return new String(hour) + ':' + new String(min);
            }
        }
        if (m == mm - 1) {
            m = 0;
            if (h == hh - 1) {
                h = 0;
            } else {
                h++;
            }
        } else {
            m++;
        }
        return f(h, m, hh, mm);
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
