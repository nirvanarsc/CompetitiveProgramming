package weekly_contests.weekly_87;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_847 {

    static class Tuple {
        int bitMask;
        int curr;
        int cost;

        Tuple(int bit, int n, int c) {
            bitMask = bit;
            curr = n;
            cost = c;
        }
    }

    public int shortestPathLength(int[][] graph) {
        final int N = graph.length;
        final Deque<Tuple> queue = new ArrayDeque<>();
        final boolean[][] visited = new boolean[graph.length][1 << graph.length];
        for (int i = 0; i < N; i++) {
            visited[i][1 << i] = true;
            queue.add(new Tuple(1 << i, i, 0));
        }
        while (!queue.isEmpty()) {
            final Tuple curr = queue.remove();
            if (curr.bitMask == (1 << N) - 1) {
                return curr.cost;
            }
            for (int v : graph[curr.curr]) {
                final int bitMask = curr.bitMask | 1 << v;
                if (!visited[v][bitMask]) {
                    queue.add(new Tuple(bitMask, v, curr.cost + 1));
                    visited[v][bitMask] = true;
                }
            }
        }
        return -1;
    }
}
