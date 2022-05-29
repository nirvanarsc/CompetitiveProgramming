package codeforces.round_750_799.round_794;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

public final class D {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int[] arr = fs.nextIntArray(4);
            int c = arr[2];
            int d = arr[3];
            final int[] f = new int[2];
            final char[] w = fs.next().toCharArray();
            final int n = w.length;
            for (char value : w) {
                f[value - 'A']++;
            }
            if (arr[0] + c + d != f[0]) {
                System.out.println("No");
                continue;
            }
            final PriorityQueue<Integer> evenA = new PriorityQueue<>();
            final PriorityQueue<Integer> evenB = new PriorityQueue<>();
            final Deque<Integer> odd = new ArrayDeque<>();
            for (int i = 0; i < n - 1; i++) {
                if (w[i] != w[i + 1]) {
                    int j = i;
                    while (j < (n - 1) && w[j] != w[j + 1]) {
                        j++;
                    }
                    final int l = j - i + 1;
                    if (l % 2 != 0) {
                        odd.add(l);
                    } else if (w[i] == 'A') {
                        evenA.add(l);
                    } else if (w[i] == 'B') {
                        evenB.add(l);
                    }
                    i = j;
                }
            }
            while (!evenA.isEmpty()) {
                int pop = evenA.remove();
                final int take = Math.min(c, pop / 2);
                c -= take;
                pop -= 2 * take;
                if (pop > 0) {
                    evenA.add(pop);
                }
                if (c == 0) {
                    break;
                }
            }
            while (!evenB.isEmpty()) {
                int pop = evenB.remove();
                final int take = Math.min(d, pop / 2);
                d -= take;
                pop -= 2 * take;
                if (pop > 0) {
                    evenB.add(pop);
                }
                if (d == 0) {
                    break;
                }
            }
            while (!evenA.isEmpty()) {
                final int pop = evenA.remove();
                final int take = Math.min(d, (pop - 1) / 2);
                d -= take;
                if (d == 0) {
                    break;
                }
            }
            while (!evenB.isEmpty()) {
                final int pop = evenB.remove();
                final int take = Math.min(c, (pop - 1) / 2);
                c -= take;
                if (c == 0) {
                    break;
                }
            }
            while (!odd.isEmpty()) {
                final int pop = odd.removeFirst();
                int take = Math.min(c, pop / 2);
                c -= take;
                take = Math.min(d, (pop - 2 * take) / 2);
                d -= take;
            }
            if (c == 0 && d == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
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

        public int[] nextIntArray(int n) throws IOException {
            final int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
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

        public long[] nextLongArray(int n) throws IOException {
            final long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
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
