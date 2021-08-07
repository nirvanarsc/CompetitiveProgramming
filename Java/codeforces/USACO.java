package codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class USACO {

    public static void main(String[] args) throws IOException {
        final Kattio fs = new Kattio("test");
        fs.println(fs.nextInt());
        fs.close();
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

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st = new StringTokenizer("");
        private String token;

        Kattio() { this(System.in, System.out); }

        Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        private String peek() {
            if (token == null) {
                try {
                    while (!st.hasMoreTokens()) {
                        final String line = r.readLine();
                        if (line == null) {
                            //noinspection ReturnOfNull
                            return null;
                        }
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException ignored) { }
            }
            return token;
        }

        public boolean hasMoreTokens() { return peek() != null; }

        private String next() {
            final String ans = peek();
            //noinspection ConstantConditions
            token = null;
            return ans;
        }

        public int nextInt() { return Integer.parseInt(next()); }

        public double nextDouble() { return Double.parseDouble(next()); }

        public long nextLong() { return Long.parseLong(next()); }
    }
}
