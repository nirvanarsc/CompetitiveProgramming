package codeforces.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public final class E {

    enum State {
        UNVISITED, VISITING, VISITED
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final Map<Integer, Set<Integer>> g = new HashMap<>();
            final int[][] queries = new int[m][2];
            for (int i = 0; i < m; i++) {
                final String[] edge = in.nextLine().split(" ");
                final int type = Integer.parseInt(edge[0]);
                final int u = Integer.parseInt(edge[1]);
                final int v = Integer.parseInt(edge[2]);
                if (type == 1) {
                    g.computeIfAbsent(u, val -> new HashSet<>()).add(v);
                }
                queries[i] = new int[] { u, v };
            }
            final int[] ans = topsort(n, g);
            if (ans == null) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 0; i < m; i++) {
                    final int u = queries[i][0];
                    final int v = queries[i][1];
                    if (ans[u] > ans[v]) {
                        System.out.println(u + " " + v);
                    } else {
                        System.out.println(v + " " + u);
                    }
                }
            }
        }
    }

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    public static int[] topsort(int n, Map<Integer, Set<Integer>> g) {
        final State[] state = new State[n + 1];
        Arrays.fill(state, State.UNVISITED);
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (state[i] == State.UNVISITED) {
                if (!visit(q, state, g, i)) {
                    return null;
                }
            }
        }
        final int[] ans = new int[n + 1];
        int i = 0;
        while (!q.isEmpty()) {
            ans[q.removeFirst()] = i++;
        }
        return ans;
    }

    public static boolean visit(Deque<Integer> q, State[] state, Map<Integer, Set<Integer>> g, int u) {
        if (state[u] == State.VISITED) {
            return true;
        }
        if (state[u] == State.VISITING) {
            return false;
        }
        state[u] = State.VISITING;
        for (int v : g.getOrDefault(u, Collections.emptySet())) {
            if (!visit(q, state, g, v)) {
                return false;
            }
        }
        state[u] = State.VISITED;
        q.offerLast(u);
        return true;
    }
}
