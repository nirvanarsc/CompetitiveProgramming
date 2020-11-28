package codeforces.educational.educational_96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final char[] s = fs.next().toCharArray();
            final TreeSet<Integer> reps = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                final char c = s[i];
                if (i < n - 1) {
                    if (c == s[i + 1]) {
                        int j = i + 1;
                        while (j < n && c == s[j]) {
                            reps.add(j);
                            j++;
                        }
                        i = j - 1;
                    }
                }
            }
            int res = 0;
            final boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                final char c = s[i];
                while (!reps.isEmpty() && reps.first() < i) {
                    reps.pollFirst();
                }
                if (!reps.isEmpty()) {
                    used[reps.pollFirst()] = true;
                    if (i < n - 1) {
                        if (c == s[i + 1]) {
                            int j = i + 1;
                            while (j < n && c == s[j]) {
                                j++;
                            }
                            i = j - 1;
                        }
                    }
                } else {
                    if (i < n - 1) {
                        int j = i + 1;
                        if (c == s[j]) {
                            while (j < n && c == s[j] && used[j]) {
                                j++;
                            }
                            if (j < n) {
                                if (c == s[j]) {
                                    while (j < n && c == s[j]) {
                                        j++;
                                    }
                                } else {
                                    final char tt = s[j];
                                    while (j < n && tt == s[j]) {
                                        j++;
                                    }
                                }
                            }
                        } else {
                            while (j < n && s[i + 1] == s[j]) {
                                j++;
                            }
                        }
                        i = j - 1;
                    }
                }
                res++;
            }
            System.out.println(res);
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
