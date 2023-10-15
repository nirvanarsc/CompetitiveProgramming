package leetcode.weekly_contests.weekly_300_399.weekly_364;

import java.util.Arrays;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static UnionFind uf;
    static boolean[] isPrime;

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

    @SuppressWarnings("AccessStaticViaInstance")
    public long countPaths(int n, int[][] edges) {
        this.n = n + 1;
        this.edges = edges;
        g = packG();
        uf = new UnionFind(n + 1);
        isPrime = sieveOfEratosthenes(n);
        for (int[] e : edges) {
            if (!isPrime[e[0]] && !isPrime[e[1]]) {
                uf.union(e[0], e[1]);
            }
            if (isPrime[e[0]]) {
                uf.size[uf.find(e[0])] = 0;
            }
            if (isPrime[e[1]]) {
                uf.size[uf.find(e[1])] = 0;
            }
        }
        long res = 0;
        for (int u = 1; u <= n; u++) {
            if (isPrime[u]) {
                long tot = 0;
                long curr = 0;
                for (int v : g[u]) {
                    tot += uf.size[uf.find(v)];
                }
                for (int v : g[u]) {
                    curr += (tot - uf.size[uf.find(v)]) * uf.size[uf.find(v)];
                }
                res += curr / 2 + tot;
            }
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes(int n) {
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

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
