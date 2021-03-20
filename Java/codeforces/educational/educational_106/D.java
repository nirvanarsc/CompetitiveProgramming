package codeforces.educational.educational_106;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class D {

    private static int[] sieveOfEratosthenes() {
        final int n = (int) 2e7;
        final int[] smallestDiv = new int[n + 1];
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (smallestDiv[i] == 0) {
                smallestDiv[i] = i;
                primes.add(i);
            }
            for (int j : primes) {
                if (i * j > n) {
                    break;
                }
                smallestDiv[i * j] = j;
                if (i % j == 0) {
                    break;
                }
            }
        }
        return smallestDiv;
    }

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        final int[] smallestDiv = sieveOfEratosthenes();
        final int[] count = new int[(int) (2e7 + 1)];
        for (int i = 2; i < count.length; i++) {
            count[i] = count[i / smallestDiv[i]] + (smallestDiv[i] != smallestDiv[i / smallestDiv[i]] ? 1 : 0);
        }
        for (int test = 0; test < t; test++) {
            final int c = fs.nextInt();
            final int d = fs.nextInt();
            final int x = fs.nextInt();
            long res = 0;
            for (int p = 1; p * p <= x; p++) {
                if (x % p == 0) {
                    res += f(count, c, d, x, p);
                    if (p != x / p) {
                        res += f(count, c, d, x, x / p);
                    }
                }
            }
            sb.append(res);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int f(int[] count, int c, int d, int x, int g) {
        int y = x / g + d;
        if (y % c != 0) {
            return 0;
        }
        y /= c;
        return 1 << count[y];
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

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) { return -ret; }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) { return -ret; }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) { return -ret; }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) { buffer[0] = -1; }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) { fillBuffer(); }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
