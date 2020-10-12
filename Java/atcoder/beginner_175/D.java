package atcoder.beginner_175;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        public UnionFind(int n) {
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
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int k = Integer.parseInt(line[1]);
        final int[] p = new int[n];
        final int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        in.nextLine();
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.union(i, p[i] - 1);
        }
        final long[] res = { (long) -1e9 };
        for (int i = 0; i < n; i++) {
            final int currCycle = uf.size[uf.find(i)];
            final long mult = k / currCycle;
            final int r = k % currCycle;
            if (k < currCycle) {
                final long[] remainderCycle = calc(p, c, k, i);
                res[0] = Math.max(res[0], Math.max(remainderCycle[0], remainderCycle[1]));
            } else {
                final long[] fullCycle = calc(p, c, currCycle, i);
                final long[] remainderCycle = calc(p, c, r, i);
                res[0] = Math.max(res[0], Math.max(fullCycle[0], fullCycle[1]));
                res[0] = Math.max(res[0], (mult - 1) * fullCycle[0] + fullCycle[1]);
                res[0] = Math.max(res[0], mult * fullCycle[0]
                                          + Math.max(remainderCycle[0], remainderCycle[1]));
            }
        }
        System.out.println(res[0]);
    }

    private static long[] calc(int[] p, int[] c, int k, int startIdx) {
        long curr = 0;
        long bestStep = (long) -1e9;
        for (int i = 0; i < k; i++) {
            final int next = p[startIdx] - 1;
            curr += c[next];
            bestStep = Math.max(bestStep, curr);
            startIdx = next;
        }
        return new long[] { curr, bestStep };
    }
}
