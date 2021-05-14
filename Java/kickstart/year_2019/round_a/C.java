package kickstart.year_2019.round_a;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public final class C {

    static int q;
    static int[][] query;

    private static boolean f(int k) {
        if (k == 0) {
            return true;
        }
        final int[] start = new int[q];
        for (int i = 0; i < q; i++) {
            int sweepTo = Math.max(query[i][0], start[i]);
            final int end = query[i][1];
            int nextStart = end;
            int count = 0;

            for (int j = i + 1; j < q; j++) {
                final int l = query[j][0];
                final int r = query[j][1];
                if (l > end) {
                    break;
                }
                if (r <= end) {
                    if (l > sweepTo) {
                        count += l - sweepTo;
                    }
                    sweepTo = Math.max(sweepTo, r);
                    if (count >= k) {
                        nextStart = l - (count - k);
                        break;
                    }
                }
            }
            if (count < k) {
                count += end - sweepTo;
                if (count < k) {
                    return false;
                }
                nextStart = end - (count - k);
            }
            for (int j = i + 1; j < q; j++) {
                final int l = query[j][0];
                final int r = query[j][1];
                if (l >= nextStart) {
                    break;
                }
                if (r > end) {
                    start[j] = Math.max(start[j], end);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            q = fs.nextInt();
            query = new int[q][2];
            for (int i = 0; i < q; i++) {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt();
                query[i] = new int[] { l, r };
            }
            Arrays.sort(query, Comparator.comparingInt(a -> a[0]));
            int lo = 0;
            int hi = n;
            while (lo <= hi) {
                final int mid = lo + hi >>> 1;
                if (f(mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            System.out.println("Case #" + x + ": " + (lo - 1));
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
