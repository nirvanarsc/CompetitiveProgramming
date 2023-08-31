package atcoder.beginner_300_399.abc_317;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public final class E {

    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] g = new char[n][m];
        final int[][] viewed = new int[n][m];
        int s = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            g[i] = fs.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'S') {
                    s = i * m + j;
                } else if (g[i][j] == 'G') {
                    e = i * m + j;
                }
            }
        }
        for (char c : "<>v^".toCharArray()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] != c) { continue; }
                    if (c == 'v') {
                        int k = i + 1;
                        while (k < n && g[k][j] == '.') {
                            viewed[k++][j] = 1;
                        }
                    } else if (c == '^') {
                        int k = i - 1;
                        while (k >= 0 && g[k][j] == '.') {
                            viewed[k--][j] = 1;
                        }
                    } else if (c == '>') {
                        int k = j + 1;
                        while (k < m && g[i][k] == '.') {
                            viewed[i][k++] = 1;
                        }
                    } else {
                        int k = j - 1;
                        while (k >= 0 && g[i][k] == '.') {
                            viewed[i][k--] = 1;
                        }
                    }
                }
            }
        }
        final int[] d = new int[n * m];
        Arrays.fill(d, (int) 1e9);
        d[s] = 0;
        final Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(s);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int u = dq.removeFirst();
                if (d[u] < level) {
                    continue;
                }
                final int r = u / m;
                final int c = u % m;
                for (int[] dir : DIRS) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m
                        && "<>v^#".indexOf(g[nr][nc]) == -1
                        && viewed[nr][nc] == 0) {
                        if (d[nr * m + nc] > d[u] + 1) {
                            d[nr * m + nc] = d[u] + 1;
                            dq.offerLast(nr * m + nc);
                        }
                    }
                }
            }
        }
        System.out.println(d[e] == (int) 1e9 ? -1 : d[e]);
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
