package atcoder.beginner_300_399.abc_322;

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
        final char[][][] g = new char[3][4][4];
        final int[][] target = new int[4][4];
        for (int i = 0; i < 3; i++) {
            g[i] = new char[4][4];
            for (int j = 0; j < 4; j++) {
                g[i][j] = fs.next().toCharArray();
                Arrays.fill(target[j], 1);
            }
        }
        final List<char[][]> f0 = f(g[0]);
        final List<char[][]> f1 = f(g[1]);
        final List<char[][]> f2 = f(g[2]);
        for (char[][] p : f0) {
            for (char[][] q : f1) {
                for (char[][] r : f2) {
                    final int[][] res = new int[4][4];
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            res[i][j] += p[i][j] == '#' ? 1 : 0;
                            res[i][j] += q[i][j] == '#' ? 1 : 0;
                            res[i][j] += r[i][j] == '#' ? 1 : 0;
                        }
                    }
                    if (Arrays.deepEquals(target, res)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    private static List<char[][]> f(char[][] g) {
        final List<char[][]> res = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                t += g[i][j] == '#' ? 1 : 0;
            }
        }
        for (int i = -4; i < 4; i++) {
            for (int j = -4; j < 4; j++) {
                char[][] curr = new char[4][4];
                int tt = 0;
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        final int ni = i + k;
                        final int nj = j + l;
                        if (0 <= ni && ni < 4 && 0 <= nj && nj < 4) {
                            curr[k][l] = g[ni][nj];
                            tt += g[ni][nj] == '#' ? 1 : 0;
                        } else {
                            curr[k][l] = '.';
                        }
                    }
                }
                if (tt == t) {
                    for (int k = 0; k < 4; k++) {
                        res.add(curr);
                        curr = rotate(curr);
                    }
                }
            }
        }
        return res;
    }

    private static char[][] rotate(char[][] matrix) {
        final int n = matrix.length;
        final char[][] res = new char[n][n];
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < (n - 1 - layer); i++) {
                final char topL = matrix[layer][i];
                final char topR = matrix[i][n - 1 - layer];
                final char botR = matrix[n - 1 - layer][n - 1 - i];
                final char botL = matrix[n - 1 - i][layer];
                res[layer][i] = botL;
                res[i][n - 1 - layer] = topL;
                res[n - 1 - layer][n - 1 - i] = topR;
                res[n - 1 - i][layer] = botR;
            }
        }
        return res;
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

        public int readSign() throws IOException {
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
