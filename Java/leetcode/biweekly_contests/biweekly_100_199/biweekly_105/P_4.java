package leetcode.biweekly_contests.biweekly_100_199.biweekly_105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        final int n = nums.length;
        final UnionFind uf = new UnionFind(n);
        final boolean[] sieve = sieveOfEratosthenes();
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        final int[] idx = new int[(int) (1e5 + 5)];
        Arrays.fill(idx, -1);
        for (int u = 0; u < n; u++) {
            int num = nums[u];
            for (int p : primes) {
                if (p * p > nums[u]) {
                    break;
                }
                while (num % p == 0) {
                    num /= p;
                    if (idx[p] == -1) {
                        idx[p] = u;
                    } else {
                        uf.union(u, idx[p]);
                    }
                }
            }
            if (num > 1) {
                if (idx[num] == -1) {
                    idx[num] = u;
                } else {
                    uf.union(u, idx[num]);
                }
            }
        }
        return uf.count == 1;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e5;
        final boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
