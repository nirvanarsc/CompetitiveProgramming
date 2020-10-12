package leetcode.weekly_contests.weekly_104;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_913 {

    public int catMouseGameG(int[][] graph) {
        final int N = graph.length;
        final int DRAW = 0, MOUSE = 1, CAT = 2;

        final int[][][] color = new int[50][50][3];
        final int[][][] degree = new int[50][50][3];

        // degree[node] : the number of neutral children of this node
        for (int m = 0; m < N; ++m) {
            for (int c = 0; c < N; ++c) {
                degree[m][c][1] = graph[m].length;
                degree[m][c][2] = graph[c].length;
                for (int x : graph[c]) {
                    if (x == 0) {
                        degree[m][c][2]--;
                        break;
                    }
                }
            }
        }

        // enqueued : all nodes that are colored
        final Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            for (int t = 1; t <= 2; ++t) {
                color[0][i][t] = MOUSE;
                queue.offerLast(new int[] { 0, i, t, MOUSE });
                if (i > 0) {
                    color[i][i][t] = CAT;
                    queue.offerLast(new int[] { i, i, t, CAT });
                }
            }
        }

        // percolate
        while (!queue.isEmpty()) {
            // for nodes that are colored :
            final int[] node = queue.removeFirst();
            final int i = node[0];
            final int j = node[1];
            final int t = node[2];
            final int c = node[3];
            // for every parent of this node i, j, t :
            for (int[] parent : parents(graph, i, j, t)) {
                final int i2 = parent[0];
                final int j2 = parent[1];
                final int t2 = parent[2];
                // if this parent is not colored :
                if (color[i2][j2][t2] == DRAW) {
                    // if the parent can make a winning move (ie. mouse to MOUSE), do so
                    if (t2 == c) {
                        color[i2][j2][t2] = c;
                        queue.offerLast(new int[] { i2, j2, t2, c });
                    } else {
                        // else, this parent has degree[parent]--, and enqueue
                        // if all children of this parent are colored as losing moves
                        degree[i2][j2][t2]--;
                        if (degree[i2][j2][t2] == 0) {
                            color[i2][j2][t2] = 3 - t2;
                            queue.offerLast(new int[] { i2, j2, t2, 3 - t2 });
                        }
                    }
                }
            }
        }

        return color[1][2][1];
    }

    // What nodes could play their turn to arrive at node (m, c, t) ?
    public List<int[]> parents(int[][] graph, int m, int c, int t) {
        final List<int[]> ans = new ArrayList<>();
        if (t == 2) {
            for (int m2 : graph[m]) {
                ans.add(new int[] { m2, c, 1 });
            }
        } else {
            for (int c2 : graph[c]) {
                if (c2 > 0) {
                    ans.add(new int[] { m, c2, 2 });
                }
            }
        }
        return ans;
    }

    public int catMouseGame(int[][] graph) {
        final int n = graph.length;
        return dfs(graph, 0, 1, 2, new Integer[2 * n][n][n]);
    }

    public int dfs(int[][] graph, int turn, int mouse, int cat, Integer[][][] dp) {
        if (turn == 2 * graph.length) {
            return 0; // endless game, draw
        }
        if (mouse == cat) {
            return dp[turn][mouse][cat] = 2; // cat win
        }
        if (mouse == 0) {
            return dp[turn][0][cat] = 1; // mouse win
        }
        if (dp[turn][mouse][cat] != null) {
            return dp[turn][mouse][cat];
        }
        final int chance = turn % 2;
        // if chance is 0, it's mouse turn to play
        if (chance == 0) {
            boolean catWin = true;
            for (int nextMove : graph[mouse]) {
                final int res = dfs(graph, turn + 1, nextMove, cat, dp);
                if (res == 1) {
                    return dp[turn][mouse][cat] = 1;
                } else if (res == 0) {
                    catWin = false; // it's a draw;
                }
            }
            return dp[turn][mouse][cat] = catWin ? 2 : 0;
        }
        boolean mouseWin = true;
        for (int nextMove : graph[cat]) {
            // Cat can't move to 0
            if (nextMove == 0) {
                continue;
            }
            final int res = dfs(graph, turn + 1, mouse, nextMove, dp);
            if (res == 2) {
                return dp[turn][mouse][cat] = 2;
            } else if (res == 0) {
                mouseWin = false; // it's a draw;
            }
        }
        return dp[turn][mouse][cat] = mouseWin ? 1 : 0;
    }
}
