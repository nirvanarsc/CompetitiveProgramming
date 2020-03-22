package weekly_contests.weekly_181;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1391 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean hasValidPath(int[][] grid) {
        final Map<String, Map<Integer, Set<Integer>>> neighbours = getStringMapMap();
        final Deque<int[]> q = new ArrayDeque<>();
        final int n = grid.length;
        final int m = grid[0].length;
        final boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        q.offerLast(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            final int[] curr = q.removeFirst();
            final int road = grid[curr[0]][curr[1]];
            if (curr[0] == n - 1 && curr[1] == m - 1) {
                return true;
            }
            for (int[] dir : DIRS) {
                final int newX = curr[0] + dir[0];
                final int newY = curr[1] + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    final Set<Integer> next = neighbours.get(dir[0] + "," + dir[1])
                                                        .getOrDefault(road, Collections.emptySet());
                    if (next.contains(grid[newX][newY])) {
                        visited[newX][newY] = true;
                        q.offerLast(new int[] { newX, newY });
                    }
                }
            }
        }
        return false;
    }

    private static Map<String, Map<Integer, Set<Integer>>> getStringMapMap() {
        final Map<String, Map<Integer, Set<Integer>>> neighbours = new HashMap<>();
        final Set<Integer> rightDir = new HashSet<>(Arrays.asList(1, 3, 5));
        final Set<Integer> leftDir = new HashSet<>(Arrays.asList(1, 4, 6));
        final Set<Integer> upDir = new HashSet<>(Arrays.asList(2, 3, 4));
        final Set<Integer> downDir = new HashSet<>(Arrays.asList(2, 5, 6));
        final Map<Integer, Set<Integer>> right = new HashMap<>();
        final Map<Integer, Set<Integer>> left = new HashMap<>();
        final Map<Integer, Set<Integer>> up = new HashMap<>();
        final Map<Integer, Set<Integer>> down = new HashMap<>();
        right.put(1, rightDir);
        right.put(4, rightDir);
        right.put(6, rightDir);
        left.put(1, leftDir);
        left.put(3, leftDir);
        left.put(5, leftDir);
        up.put(2, upDir);
        up.put(5, upDir);
        up.put(6, upDir);
        down.put(2, downDir);
        down.put(3, downDir);
        down.put(4, downDir);
        neighbours.put("0,1", right);
        neighbours.put("0,-1", left);
        neighbours.put("-1,0", up);
        neighbours.put("1,0", down);
        return neighbours;
    }
}
