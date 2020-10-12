package codeforces.tree_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            g.computeIfAbsent(l, v -> new ArrayList<>()).add(r);
            g.computeIfAbsent(r, v -> new ArrayList<>()).add(l);
        }
        final Deque<Integer> q = new ArrayDeque<>(Collections.singletonList(0));
        final Set<Integer> furthest = new HashSet<>();
        bfs(g, q, new boolean[n], furthest);
        if (furthest.isEmpty()) {
            pw.println(1);
            pw.flush();
            return;
        }
        final Set<Integer> diameterSet = new HashSet<>();
        q.offerLast(furthest.iterator().next());
        final int diameter = bfs(g, q, new boolean[n], diameterSet);
        diameterSet.addAll(furthest);
        for (int i = 0; i < n; i++) {
            pw.println(diameterSet.contains(i) ? diameter + 1 : diameter);
        }
        pw.flush();
    }

    private static int bfs(Map<Integer, List<Integer>> g, Deque<Integer> q, boolean[] seen, Set<Integer> res) {
        int furthest = 0;
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final Integer curr = q.removeFirst();
                if (seen[curr]) {
                    continue;
                }
                seen[curr] = true;
                if (level > furthest) {
                    furthest = level;
                    res.clear();
                }
                res.add(curr);
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    q.offerLast(next);
                }
            }
        }
        return furthest;
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
