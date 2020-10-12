package leetcode.weekly_contests.weekly_49;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class P_675 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int cutOffTree(List<List<Integer>> forest) {
        final PriorityQueue<Integer> trees = new PriorityQueue<>();
        for (List<Integer> f : forest) {
            for (int num : f) {
                if (num != 0) {
                    trees.offer(num);
                }
            }
        }
        int x = 0;
        int y = 0;
        int res = 0;
        while (!trees.isEmpty()) {
            final int[] bfs = bfs(forest, x, y, trees.remove());
            if (bfs[2] == -1) {
                return -1;
            }
            x = bfs[0];
            y = bfs[1];
            res += bfs[2];
        }
        return res;
    }

    private static int[] bfs(List<List<Integer>> forest, int r, int c, int target) {
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(new int[] { r, c }));
        final boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[r][c] = true;
        for (int i = 0; !q.isEmpty(); i++) {
            for (int k = q.size(); k > 0; k--) {
                final int[] curr = q.removeFirst();
                if (forest.get(curr[0]).get(curr[1]) == target) {
                    return new int[] { curr[0], curr[1], i };
                }
                for (int[] dir : DIRS) {
                    final int nx = curr[0] + dir[0];
                    final int ny = curr[1] + dir[1];
                    if (nx >= 0 && nx < forest.size() && ny >= 0 && ny < forest.get(0).size()) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                            visited[nx][ny] = true;
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return new int[] { -1, -1, -1 };
    }
}
