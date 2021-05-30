package atcoder.beginner_200_299.abc_203;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = fs.nextInt();
            }
        }
        final TreeSet<int[]> min = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(a[1], b[1]));
        final TreeSet<int[]> max = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(b[1], a[1]));
        final boolean even = k % 2 == 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                final int[] add = { i * n + j, g[i][j] };
                min.add(add);
                max.add(min.pollFirst());
                if (max.size() > min.size()) {
                    min.add(max.pollFirst());
                }
            }
        }
        int res = even ? max.first()[1] : min.first()[1];
        int r = 0;
        boolean right = true;
        while (r < (n - k)) {
            if (right) {
                for (int col = k; col < n; col++) {
                    for (int row = r; row < r + k; row++) {
                        final int[] rem = { row * n + (col - k), g[row][col - k] };
                        max.remove(rem);
                        min.remove(rem);

                        final int[] add = { row * n + col, g[row][col] };
                        min.add(add);
                        max.add(min.pollFirst());
                        if (max.size() > min.size()) {
                            min.add(max.pollFirst());
                        }
                    }
                    res = Math.min(res, even ? max.first()[1] : min.first()[1]);
                }
                // go down
                if (r < (n - k)) {
                    for (int col = n - k; col < n; col++) {
                        final int[] rem = { r * n + col, g[r][col] };
                        max.remove(rem);
                        min.remove(rem);

                        final int[] add = { (r + k) * n + col, g[r + k][col] };
                        min.add(add);
                        max.add(min.pollFirst());
                        if (max.size() > min.size()) {
                            min.add(max.pollFirst());
                        }
                    }
                    res = Math.min(res, even ? max.first()[1] : min.first()[1]);
                    r++;
                }
                right = false;
            } else {
                for (int col = n - k - 1; col >= 0; col--) {
                    for (int row = r; row < r + k; row++) {
                        final int[] rem = { row * n + col + k, g[row][col + k] };
                        max.remove(rem);
                        min.remove(rem);

                        final int[] add = { row * n + col, g[row][col] };
                        min.add(add);
                        max.add(min.pollFirst());
                        if (max.size() > min.size()) {
                            min.add(max.pollFirst());
                        }
                    }
                    res = Math.min(res, even ? max.first()[1] : min.first()[1]);
                }
                // go down
                if (r < (n - k)) {
                    for (int col = 0; col < k; col++) {
                        final int[] rem = { r * n + col, g[r][col] };
                        max.remove(rem);
                        min.remove(rem);

                        final int[] add = { (r + k) * n + col, g[r + k][col] };
                        min.add(add);
                        max.add(min.pollFirst());
                        if (max.size() > min.size()) {
                            min.add(max.pollFirst());
                        }
                    }
                    res = Math.min(res, even ? max.first()[1] : min.first()[1]);
                    r++;
                }
                right = true;
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
