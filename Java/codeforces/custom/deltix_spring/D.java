package codeforces.custom.deltix_spring;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class D {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final Random r = new Random();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int p = fs.nextInt();
        final long[] g = new long[n];
        for (int i = 0; i < n; i++) {
            final char[] w = fs.next().toCharArray();
            long curr = 0L;
            for (int j = 0; j < m; j++) {
                if (w[j] == '1') {
                    curr |= 1L << j;
                }
            }
            g[i] = curr;
        }
        int max = 0;
        char[] res = new char[m];
        Arrays.fill(res, '0');
        for (int i = 0; i < 10; i++) {
            final long curr = g[r.nextInt(n)];
            final List<Integer> bits = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if ((curr & (1L << j)) != 0) {
                    bits.add(j);
                }
            }
            final int t = bits.size();
            final int[] count = new int[1 << t];
            for (int j = 0; j < n; j++) {
                int person = 0;
                for (int k = 0; k < t; k++) {
                    if ((g[j] & (1L << bits.get(k))) != 0) {
                        person |= 1 << k;
                    }
                }
                count[person]++;
            }
            // super masks
            for (int j = 0; j < t; j++) {
                for (int mask = 0; mask < (1 << t); mask++) {
                    if ((mask & (1 << j)) != 0) {
                        count[mask ^ (1 << j)] += count[mask];
                    }
                }
            }
            for (int mask = 0; mask < (1 << t); mask++) {
                if (count[mask] >= ((n + 1) / 2)) {
                    if (max < Integer.bitCount(mask)) {
                        max = Integer.bitCount(mask);
                        final char[] next = new char[m];
                        Arrays.fill(next, '0');
                        for (int j = 0; j < t; j++) {
                            if ((mask & (1 << j)) != 0) {
                                next[bits.get(j)] = '1';
                            }
                        }
                        res = next;
                    }
                }
            }
        }
        System.out.println(res);
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

        private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {}
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
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
