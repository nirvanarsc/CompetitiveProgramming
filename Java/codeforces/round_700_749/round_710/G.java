package codeforces.round_700_749.round_710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

@SuppressWarnings({ "unchecked", "ConstantConditions" })
public final class G {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int mask;

        SegTree(int leftMost, int rightMost, char[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                mask |= 1 << arr[leftMost] - 'a';
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                mask = left.mask | right.mask;
            }
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return mask;
            }
            return left.query(l, r) | right.query(l, r);
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final char[] s = fs.next().toCharArray();
            final TreeSet<Integer>[] ts = new TreeSet[26];
            final SegTree st = new SegTree(0, s.length - 1, s);
            for (int i = 0; i < 26; i++) {
                ts[i] = new TreeSet<>();
            }
            for (int i = 0; i < s.length; i++) {
                ts[s[i] - 'a'].add(i);
            }
            final StringBuilder sb = new StringBuilder();
            int i = 0;
            int mask = st.mask;
            while (mask > 0) {
                for (int j = 25; j >= 0; j--) {
                    if ((mask & (1 << j)) != 0) {
                        final char c = (char) ('a' + j);
                        final int ceiling = ts[j].ceiling(i);
                        final int complement = st.query(ceiling, s.length - 1);
                        if ((mask & complement) == mask) {
                            sb.append(c);
                            mask ^= 1 << j;
                            i = ceiling + 1;
                            break;
                        }
                    }
                }
            }
            System.out.println(sb);
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

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
