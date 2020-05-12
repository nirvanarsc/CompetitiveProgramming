package weekly_contests.weekly_17;

import java.util.PriorityQueue;

public class P_499 {

    static class Path {
        int r;
        int c;
        int d;
        String path;

        Path(int r, int c, int d, String path) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.path = path;
        }
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static final String directions = "rldu";

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int n = maze.length;
        final int m = maze[0].length;
        final PriorityQueue<Path> q = new PriorityQueue<>((a, b) -> a.d == b.d ? a.path.compareTo(b.path)
                                                                               : Integer.compare(a.d, b.d));
        q.offer(new Path(ball[0], ball[1], 0, ""));
        final boolean[][] visited = new boolean[n][m];
        while (!q.isEmpty()) {
            final Path curr = q.remove();
            if (curr.r == hole[0] && curr.c == hole[1]) {
                return curr.path;
            }
            if (!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
                for (int i = 0; i < DIRS.length; i++) {
                    int nx = curr.r;
                    int ny = curr.c;
                    int d = 0;
                    while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0) {
                        if (nx == hole[0] && ny == hole[1]) {
                            q.offer(new Path(nx, ny, curr.d + d, curr.path + directions.charAt(i)));
                        }
                        d++;
                        nx += DIRS[i][0];
                        ny += DIRS[i][1];
                    }
                    nx -= DIRS[i][0];
                    ny -= DIRS[i][1];
                    d--;
                    q.offer(new Path(nx, ny, curr.d + d, curr.path + directions.charAt(i)));
                }
            }
        }
        return "impossible";
    }
}
