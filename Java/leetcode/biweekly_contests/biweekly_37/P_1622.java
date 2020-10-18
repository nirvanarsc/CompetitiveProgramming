package leetcode.biweekly_contests.biweekly_37;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1622 {

    class FancyST {
        private static final int MOD = (int) (1e9 + 7);

        private class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            // A * x + B
            long[] linear = { 1, 0 };

            SegTree(int leftMost, int rightMost) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
            }

            private void recalc() {
                if (leftMost == rightMost) {
                    return;
                }
                linear = merge(left.linear, right.linear);
            }

            // composition of 2 linear functions: C * (A * x + B) + D = (A * C) * x + (B * C + D)
            private long[] merge(long[] left, long[] right) {
                return new long[] { left[0] * right[0] % MOD, (left[1] * right[0] + right[1]) % MOD };
            }

            private void createChildren() {
                if (left == null || right == null) {
                    final int mid = leftMost + rightMost >>> 1;
                    left = new SegTree(leftMost, mid);
                    right = new SegTree(mid + 1, rightMost);
                    recalc();
                }
            }

            private long[] query(int l, int r) {
                createChildren();
                if (r < leftMost || l > rightMost) {
                    return new long[] { 1, 0 };
                }
                if (l <= leftMost && rightMost <= r) {
                    return linear;
                }
                return merge(left.query(l, r), right.query(l, r));
            }

            private void update(int idx, long[] val) {
                createChildren();
                if (leftMost == rightMost) {
                    linear = merge(linear, val);
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

        List<Integer> raw = new ArrayList<>();
        SegTree st;

        FancyST() {
            final int n = (int) (1e5 + 5);
            st = new SegTree(0, n - 1);
        }

        public void append(int val) {
            raw.add(val);
        }

        public void addAll(int inc) {
            st.update(raw.size() - 1, new long[] { 1, inc });
        }

        public void multAll(int m) {
            st.update(raw.size() - 1, new long[] { m, 0 });
        }

        public int getIndex(int idx) {
            if (idx >= raw.size()) {
                return -1;
            }
            final long[] linear = st.query(idx, raw.size() - 1);
            final long ll = (linear[0] * raw.get(idx)) % MOD;
            final long res = (ll + linear[1]) % MOD;
            return (int) res;
        }
    }

    class Fancy {

        private static final int MOD = (int) (1e9 + 7);
        List<Long> list = new ArrayList<>();
        long[] linear = { 1, 0 };

        public void append(int val) {
            long v = val;
            v = (v + MOD - linear[1]) % MOD;
            // Fermat's little theorem = mod inverse for primes
            v = (v * modPow(linear[0], MOD - 2)) % MOD;
            list.add(v);
        }

        public void addAll(int inc) {
            linear[1] = (linear[1] + inc) % MOD;
        }

        public void multAll(int m) {
            linear[0] = linear[0] * m % MOD;
            linear[1] = linear[1] * m % MOD;
        }

        public int getIndex(int idx) {
            if (idx >= list.size()) { return -1; }
            long v = list.get(idx);
            v = v * linear[0] % MOD;
            v = (v + linear[1]) % MOD;
            return (int) v;
        }

        public long modPow(long a, long n) {
            long res = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                n /= 2;
            }
            return res;
        }
    }
}
