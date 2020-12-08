package codeforces.round_600_649.round_632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = left.sum + right.sum;
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum += val;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, val);
                } else {
                    right.update(idx, val);
                }
                recalc();
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        int k = fs.nextInt();
        final String s = fs.next();
        final int[] arr = new int[n];
        int[] swaps = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) == 'R' ? 1 : 0;
        }
        final SegTree st = new SegTree(0, n - 1, swaps);
        int need = 0;
        for (int i = n - 1; i >= 0; i--) {
            swaps[i] = st.query(0, arr[i] - 1);
            st.update(arr[i], 1);
            need += swaps[i];
        }
        if (need < k) {
            pw.println(-1);
        } else {
            final List<String> lines = new ArrayList<>();
            final Deque<Integer> dq = new ArrayDeque<>();
            while (k > 0) {
                final int[] nextS = swaps.clone();
                for (int i = n - 1; i >= 1; i--) {
                    if (swaps[i - 1] > 0 && swaps[i] == 0) {
                        dq.addLast(i);
                        nextS[i] = nextS[i - 1] - 1;
                        nextS[i - 1] = 0;
                    }
                }
                boolean done = false;
                if (need - dq.size() + 1 > k) {
                    final int curr = dq.size();
                    final StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < curr; i++) {
                        sb.append(dq.removeFirst());
                        sb.append(' ');
                    }
                    lines.add(curr + " " + sb);
                    need -= curr;
                } else {
                    final int curr = need - k + 1;
                    final StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < curr; i++) {
                        sb.append(dq.removeFirst());
                        sb.append(' ');
                    }
                    lines.add(curr + " " + sb);
                    need -= curr;
                    done = true;
                }
                k -= 1;
                swaps = nextS;
                if (done) {
                    break;
                }
            }
            if (k == 0 && need > 0) {
                pw.println(-1);
            } else {
                for (String line : lines) {
                    pw.println(line);
                }
                final List<Integer> res = new ArrayList<>();
                while (!dq.isEmpty()) {
                    res.add(dq.removeFirst());
                }
                for (int i = n - 1; i >= 0; i--) {
                    int curr = i + 1;
                    for (int j = 0; j < swaps[i]; j++) {
                        res.add(curr++);
                    }
                }
                int idx = 0;
                for (int i = 0; i < k; i++) {
                    pw.println(1 + " " + res.get(idx++));
                }
            }
        }
        pw.close();
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
