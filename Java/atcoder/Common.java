package atcoder;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class Common {

    private static final int MOD = (int) (1e9 + 7);

    private static class Combinations {
        long[] factorial;
        long[] facInverse;
        long[] inverse;

        Combinations(int n) {
            final int MAX = n + 2;
            factorial = new long[MAX];
            facInverse = new long[MAX];
            inverse = new long[MAX];
            factorial[0] = factorial[1] = 1;
            facInverse[0] = facInverse[1] = 1;
            inverse[1] = 1;
            for (int i = 2; i < MAX; i++) {
                factorial[i] = factorial[i - 1] * i % MOD;
                final long inv = inverse[i] = MOD - inverse[MOD % i] * (MOD / i) % MOD;
                facInverse[i] = facInverse[i - 1] * inv % MOD;
            }
        }

        long nck(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * (facInverse[k] * facInverse[n - k] % MOD) % MOD;
        }

        // combinations with repetition
        long ncr(int n, int k) {
            return nck(n + k - 1, k);
        }

        // permutations with repetition
        long npk(int n, int k) {
            if (n < k) { return 0; }
            if (n < 0 || k < 0) { return 0; }
            return factorial[n] * facInverse[n - k] % MOD;
        }

        long modPow(long a, long n) {
            long res = 1;
            while (n > 0) {
                if (n % 2 != 0) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                n /= 2;
            }
            return res;
        }
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;

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

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, long val) {
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

    private static class CombinationIterator {
        int n;
        int k;
        int[] combination;

        CombinationIterator(int n, int k) {
            this.n = n;
            this.k = k;
            combination = IntStream.range(0, k).toArray();
        }

        @SuppressWarnings("ConstantConditions")
        public int[] next() {
            final int[] res = combination.clone();
            combination = nextCombination(combination, n, k);
            return res;
        }

        public boolean hasNext() {
            return combination != null;
        }

        @SuppressWarnings("ReturnOfNull")
        private static int[] nextCombination(int[] curr, int n, int k) {
            if (curr[k - 1] < n - 1) {
                curr[k - 1]++;
                return curr;
            }
            int idx = k - 1;
            while (idx > 0 && curr[idx] == curr[idx - 1] + 1) {
                idx--;
            }
            if (idx == 0) {
                return null;
            }
            idx--;
            curr[idx]++;
            for (int i = idx + 1; i < k; i++) {
                curr[i] = curr[i - 1] + 1;
            }
            return curr;
        }
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
    }

    // Prefix XOR (1 ^ 2 ^ 3 ... ^ n)
    private static int prefixXor(int n) {
        // If n is a multiple of 4
        if (n % 4 == 0) {
            return n;
        }
        // If n % 4 gives remainder 1
        if (n % 4 == 1) {
            return 1;
        }
        // If n % 4 gives remainder 2
        if (n % 4 == 2) {
            return n + 1;
        }
        // If n % 4 gives remainder 3
        return 0;
    }
}
