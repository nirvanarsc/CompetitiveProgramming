package codeforces.round_650_699.round_665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("ConstantConditions")
public final class D {

    static class Node {
        List<Node> adj = new ArrayList<>();
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
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

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    private static final long MOD = (long) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = fs.nextInt();
            final Node[] g = new Node[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Node(i);
            }
            for (int i = 1; i < n; i++) {
                final int u = fs.nextInt() - 1;
                final int v = fs.nextInt() - 1;
                g[u].adj.add(g[v]);
                g[v].adj.add(g[u]);
            }
            final int m = fs.nextInt();
            final int[] primes = fs.readArray(m);
            final PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            for (int i = 0; i < m; i++) { pq1.offer(primes[i]); }
            final long[] factors = new long[n - 1];
            final long[] size = new long[n];
            dfs(g[0], null, size);
            Arrays.fill(factors, 1);
            boolean changeLast = false;
            for (int i = 0; i < n - 1; i++) {
                factors[i] = pq1.isEmpty() ? 1 : pq1.remove();
                if (i == n - 2) {
                    while (!pq1.isEmpty()) {
                        factors[i] = (factors[i] * pq1.remove()) % MOD;
                        if (i > 0 && factors[i] < factors[i - 1]) {
                            changeLast = true;
                        }
                    }
                }
            }
            final long[] edgeWeights = new long[n - 1];
            // since we rooted the tree at node 0, size[0] * (n - size[0]) = 0;
            for (int i = 1; i < n; i++) {
                edgeWeights[i - 1] = size[i] * (n - size[i]);
            }
            long temp = 0;
            if (changeLast) {
                temp = factors[n - 2];
                factors[n - 2] = MOD;
            }
            Arrays.sort(edgeWeights);
            Arrays.sort(factors);
            if (changeLast) {
                factors[n - 2] = temp;
            }
            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                ans = (ans + (factors[i] * edgeWeights[i]) % MOD) % MOD;
            }
            System.out.println(ans);
        }
    }

    private static void dfs(Node curr, Node parent, long[] size) {
        size[curr.val] = 1;
        for (Node next : curr.adj) {
            if (next != parent) {
                dfs(next, curr, size);
                size[curr.val] += size[next.val];
            }
        }
    }

//    private static int subarraySum(int[] arr) {
//        int result = 0;
//        for (int i = 0; i < arr.length; i++) {
//            result += arr[i] * (i + 1) * (arr.length - i);
//        }
//        return result;
//    }
}
