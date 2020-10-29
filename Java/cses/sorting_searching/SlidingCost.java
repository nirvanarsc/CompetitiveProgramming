package cses.sorting_searching;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public final class SlidingCost {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final StringBuilder sb = new StringBuilder();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        final TreeSet<int[]> min = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(a[1], b[1]));
        final TreeSet<int[]> max = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(b[1], a[1]));
        final boolean even = k % 2 == 0;
        final long lSize = k / 2 + k % 2;
        final long rSize = k / 2;
        int median;
        long sumLow = 0, sumHigh = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                final int[] rem = { i - k, arr[i - k] };
                if (max.remove(rem)) {
                    sumHigh -= arr[i - k];
                } else {
                    min.remove(rem);
                    sumLow -= arr[i - k];
                }
            }
            final int[] add = { i, arr[i] };
            min.add(add);
            sumLow += add[1];
            final int[] pop1 = min.pollFirst();
            max.add(pop1);
            sumLow -= pop1[1];
            sumHigh += pop1[1];
            if (max.size() > min.size()) {
                final int[] pop2 = max.pollFirst();
                min.add(pop2);
                sumLow += pop2[1];
                sumHigh -= pop2[1];
            }
            if (i >= k - 1) {
                median = even ? max.first()[1] : min.first()[1];
                sb.append(sumLow - lSize * median + rSize * median - sumHigh);
                sb.append(' ');
            }
        }
        System.out.println(sb);
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
            final byte[] buf = new byte[64]; // line length
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
