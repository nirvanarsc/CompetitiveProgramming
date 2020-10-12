package codeforces.tree_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) throws IOException {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            g.computeIfAbsent(l, v -> new ArrayList<>()).add(r);
            g.computeIfAbsent(r, v -> new ArrayList<>()).add(l);
        }
        final int[] res = { 0 };
        dfs(0, -1, res, g);
        System.out.println(res[0] * 3);
    }

    private static int dfs(int curr, int par, int[] diameter, Map<Integer, List<Integer>> g) {
        int maxDepth = 0;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            if (next == par) {
                continue;
            }
            final int depth = dfs(next, curr, diameter, g);
            diameter[0] = Math.max(diameter[0], depth + maxDepth);
            maxDepth = Math.max(depth, maxDepth);
        }
        return maxDepth + 1;
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
}
