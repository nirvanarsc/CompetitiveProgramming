package codeforces.round_700_749.round_709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[] freq = new int[n + 1];
            final List<int[]> days = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                final int k = fs.nextInt();
                final int[] day = new int[k + 1];
                for (int j = 0; j < k; j++) {
                    day[j] = fs.nextInt();
                }
                day[k] = i;
                days.add(day);
            }
            days.sort(Comparator.comparingInt(a -> a.length));
            final int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                if (days.get(i).length == 2) {
                    freq[days.get(i)[0]]++;
                    res[days.get(i)[1]] = days.get(i)[0];
                } else {
                    int min = -1;
                    int minn = (int) 1e9;
                    for (int j = 0; j < days.get(i).length - 1; j++) {
                        if (freq[days.get(i)[j]] < minn) {
                            minn = freq[days.get(i)[j]];
                            min = days.get(i)[j];
                        }
                    }
                    freq[min]++;
                    res[days.get(i)[days.get(i).length - 1]] = min;
                }
            }
            final int max = (m + 1) / 2;
            for (int i = 1; i <= n; i++) {
                if (freq[i] > max) {
                    sb.append("NO");
                    sb.append('\n');
                    continue outer;
                }
            }
            sb.append("YES");
            sb.append('\n');
            for (int i = 0; i < m; i++) {
                sb.append(res[i]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
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
