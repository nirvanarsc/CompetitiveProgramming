package leetcode.weekly_contests.weekly_200_299.weekly_285;

import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_4 {

    // Assignment & Maximum
    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long max;
        long operation = Long.MAX_VALUE;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                max = Math.max(left.max, right.max);
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
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            left.max = operation(left.max, operation);
            right.max = operation(right.max, operation);
            operation = Long.MAX_VALUE;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return (long) -1e9;
            }
            if (l <= leftMost && rightMost <= r) {
                return max;
            }
            return Math.max(left.query(l, r), right.query(l, r));
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                operation = operation(operation, v);
                max = v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            max = Math.max(left.max, right.max);
        }
    }

    static TreeSet<Integer> ts;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        final char[] w = s.toCharArray();
        final int n = s.length();
        final int[] arr = new int[n];
        ts = new TreeSet<>();
        ts.add(n);
        for (int i = 0; i < n; i++) {
            ts.add(i);
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            final int l = j - i;
            for (int k = i; k < j; k++) {
                arr[k] = l;
            }
            i = j - 1;
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        final int q = queryCharacters.length();
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final char c = queryCharacters.charAt(i);
            final int u = queryIndices[i];
            if (w[u] == c) {
                res[i] = (int) st.max;
                continue;
            }
            int l = ts.floor(u);
            int r = ts.higher(u) - 1;
            if (u == l && u == r) {
                int updated = 1;
                if (u > 0 && w[u - 1] == c) {
                    updated += st.query(u - 1, u - 1);
                    ts.remove(l);
                    l = ts.floor(u - 1);
                }
                if (u < (n - 1) && w[u + 1] == c) {
                    updated += st.query(u + 1, u + 1);
                    ts.remove(r + 1);
                    r = ts.higher(u + 1) - 1;
                }
                st.add(l, r, updated);
            } else if (u == l) {
                int updated = 1;
                final int curr = (int) st.query(u, u);
                if (u > 0 && w[u - 1] == c) {
                    updated += st.query(u - 1, u - 1);
                    ts.remove(l);
                    l = ts.floor(u - 1);
                }
                st.add(l, u, updated);
                st.add(u + 1, ts.higher(u + 1) - 1, curr - 1);
                ts.add(u + 1);
            } else if (u == r) {
                int updated = 1;
                final int curr = (int) st.query(u, u);
                if (u < (n - 1) && w[u + 1] == c) {
                    updated += st.query(u + 1, u + 1);
                    ts.remove(r + 1);
                    r = ts.higher(u + 1) - 1;
                }
                st.add(ts.floor(u - 1), u - 1, curr - 1);
                st.add(u, r, updated);
                ts.add(u);
            } else {
                ts.add(u);
                ts.add(u + 1);
                st.add(l, u - 1, u - l);
                st.add(u, u, 1);
                st.add(u + 1, r, r - u);
            }
            w[u] = c;
            res[i] = (int) st.max;
        }
        return res;
    }
}
