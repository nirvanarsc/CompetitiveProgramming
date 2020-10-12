package codeforces.segment_trees.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class A {

    // https://codeforces.com/blog/entry/53052

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long assignmentOperation = Long.MAX_VALUE;
        long additionOperation;

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost != rightMost) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
            }
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            return b;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            if (assignmentOperation == Long.MAX_VALUE) {
                // addition
                if (left.assignmentOperation != Long.MAX_VALUE) {
                    left.assignmentOperation += additionOperation;
                } else {
                    left.additionOperation += additionOperation;
                }
                if (right.assignmentOperation != Long.MAX_VALUE) {
                    right.assignmentOperation += additionOperation;
                } else {
                    right.additionOperation += additionOperation;
                }
                left.sum += (left.rightMost - left.leftMost + 1) * additionOperation;
                right.sum += (right.rightMost - right.leftMost + 1) * additionOperation;
                additionOperation = 0;
            } else {
                // assignment
                left.assignmentOperation = operation(left.assignmentOperation, assignmentOperation);
                right.assignmentOperation = operation(right.assignmentOperation, assignmentOperation);
                left.additionOperation = 0;
                right.additionOperation = 0;
                left.sum = (left.rightMost - left.leftMost + 1) * assignmentOperation;
                right.sum = (right.rightMost - right.leftMost + 1) * assignmentOperation;
                assignmentOperation = Long.MAX_VALUE;
            }
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void assign(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                assignmentOperation = operation(assignmentOperation, v);
                sum = (rightMost - leftMost + 1) * v;
                return;
            }
            left.assign(l, r, v);
            right.assign(l, r, v);
            sum = left.sum + right.sum;
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                additionOperation += v;
                sum += (rightMost - leftMost + 1) * v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final SegTree st = new SegTree(0, n - 1);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            if (type == 1) {
                st.assign(l, r - 1, fs.nextInt());
            } else if (type == 2) {
                st.add(l, r - 1, fs.nextInt());
            } else {
                pw.println(st.query(l, r - 1));
            }
        }
        pw.close();
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
