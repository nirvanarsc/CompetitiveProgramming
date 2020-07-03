package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class P_711 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static final int[][] DIHEDRAL_DIRS = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    // https://en.wikipedia.org/wiki/Dihedral_group
    public int numDistinctIslands2(int[][] grid) {
        final Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    final List<int[]> cells = new ArrayList<>();
                    dfs(i, j, grid, cells);
                    islands.add(norm(cells));
                }
            }
        }
        return islands.size();
    }

    private static String norm(List<int[]> cells) {
        final TreeSet<String> normShapes = new TreeSet<>();
        for (int[] dir : DIHEDRAL_DIRS) {
            final List<int[]> s1 = new ArrayList<>();
            final List<int[]> s2 = new ArrayList<>();
            for (int[] cell : cells) {
                final int x = cell[0];
                final int y = cell[1];
                s1.add(new int[] { dir[0] * x, dir[1] * y });
                s2.add(new int[] { dir[0] * y, dir[1] * x });
            }
            for (List<int[]> s : Arrays.asList(s1, s2)) {
                // Sort is not important, just used to always pick the same value when hashing the path
                s.sort((o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0])
                                                  : Integer.compare(o1[1], o2[1]));
                final int x = s.get(0)[0];
                final int y = s.get(0)[1];
                final StringBuilder b = new StringBuilder();
                for (int[] p : s) {
                    b.append(p[0] - x).append(':').append(p[1] - y).append(':');
                }
                normShapes.add(b.toString());
            }
        }
        return normShapes.first();
    }

    private static void dfs(int i, int j, int[][] grid, List<int[]> cells) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        cells.add(new int[] { i, j });
        grid[i][j] = -1;
        for (int[] dir : DIRS) {
            dfs(i + dir[0], j + dir[1], grid, cells);
        }
    }
}
