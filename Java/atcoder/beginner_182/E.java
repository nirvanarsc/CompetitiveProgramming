package atcoder.beginner_182;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import utils.DataStructures.TreeNode;

public final class E {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] grid = new int[h][w];
        for (int i = 0; i < n; i++) {
            grid[fs.nextInt() - 1][fs.nextInt() - 1] = 2;
        }
        for (int i = 0; i < m; i++) {
            grid[fs.nextInt() - 1][fs.nextInt() - 1] = 3;
        }
        // horizontal
        for (int i = 0; i < h; i++) {
            int s = 0;
            boolean ok = false;
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 2) {
                    ok = true;
                }
                if (grid[i][j] == 3 || j == w - 1) {
                    if (ok) {
                        for (int k = s; k <= j; k++) {
                            if (grid[i][k] == 0) {
                                grid[i][k] = 1;
                            }
                        }
                        ok = false;
                    }
                    s = j + 1;
                }
            }
        }
        // vertical
        for (int i = 0; i < w; i++) {
            int s = 0;
            boolean ok = false;
            for (int j = 0; j < h; j++) {
                if (grid[j][i] == 2) {
                    ok = true;
                }
                if (grid[j][i] == 3 || j == h - 1) {
                    if (ok) {
                        for (int k = s; k <= j; k++) {
                            if (grid[k][i] == 0) {
                                grid[k][i] = 1;
                            }
                        }
                        ok = false;
                    }
                    s = j + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
