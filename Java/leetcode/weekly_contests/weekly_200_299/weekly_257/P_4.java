package leetcode.weekly_contests.weekly_200_299.weekly_257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    public boolean gcdSort(int[] nums) {
        final int n = nums.length;
        final UnionFind uf = new UnionFind(n);
        final int[] par = new int[(int) (1e5 + 5)];
        final int[][] indexed = new int[n][2];
        final boolean[] sieve = sieveOfEratosthenes();
        Arrays.fill(par, -1);
        final List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { nums[i], i };
            int curr = nums[i];
            for (int p : primes) {
                if (p * p > nums[i]) {
                    break;
                }
                if (curr % p == 0) {
                    if (par[p] == -1) {
                        par[p] = i;
                    }
                    uf.union(i, par[p]);
                    while (curr % p == 0) {
                        curr /= p;
                    }
                }
            }
            if (sieve[curr]) {
                if (par[curr] == -1) {
                    par[curr] = i;
                }
                uf.union(i, par[curr]);
            }
        }
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            if (indexed[i][0] != nums[i]) {
                if (uf.find(i) != uf.find(indexed[i][1])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e5;
        final boolean[] prime = new boolean[n + 5];
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
