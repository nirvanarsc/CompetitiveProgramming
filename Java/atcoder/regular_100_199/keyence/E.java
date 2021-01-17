package atcoder.regular_100_199.keyence;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.io.Writer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class E {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            DChoosingUpSides solver = new DChoosingUpSides();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class DChoosingUpSides {
        int[][][] mem = new int[256][][];

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int N = in.ri();
            int n = 1 << (N - 1);
            out.println(2 * n - 1);
            int[][] ans = commonIntersect(2 * n - 1);
            for (int i = 0; i < 2 * n - 1; i++) {
                for (int j = 0; j < ans.length; j++) {
                    char c = (char) ('A' + ans[j][i]);
                    out.append(c);
                }
                out.println();
            }
        }

        public int[][] commonIntersect(int n) {
            assert Integer.lowestOneBit(n + 1) == n + 1;
            if (mem[n] == null) {
                if (n == 0) {
                    return mem[n] = new int[1][n];
                }
                int r = (n + 1);
                int[][] mat = new int[r][];
                mat[0] = new int[n];
                int wpos = 1;
                for (int k = (n + 1) / 2; k >= 1; k /= 2) {
                    int step = k * 2;
                    int cnt = n / step;
                    int[][] bits = commonIntersect(cnt);
                    for (int[] bit : bits) {
                        int[] init = new int[n];
                        for (int j = 0; j < n; j++) {
                            int b = j / step >= bit.length ? 0 : bit[j / step];
                            init[j] = (j / k % 2) ^ 1 ^ b;
                        }
                        mat[wpos++] = init;
                    }
                }
                mem[n] = mat;
                assert mat.length == (n + 1);
            }
            return mem[n];
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 1 << 13;
        private final Writer os;
        private StringBuilder cache = new StringBuilder(THRESHOLD * 2);

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        private void afterWrite() {
            if (cache.length() < THRESHOLD) {
                return;
            }
            flush();
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(int c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println(int c) {
            return append(c).println();
        }

        public FastOutput println() {
            return append(System.lineSeparator());
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }

    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public int ri() {
            return readInt();
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

    }
}

