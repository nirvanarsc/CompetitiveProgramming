package atcoder.grand_44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class B {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final boolean[][] matrix = new boolean[n][n];
        in.nextLine();
        final int[] exits = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            exits[i] = in.nextInt();
        }
        final Map<Integer, int[]> map = new HashMap<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = true;
                map.put(curr++, new int[] { i, j });
            }
        }
        int res = 0;
        Integer[][] dp = new Integer[n][n];
        for (int exit : exits) {
            final int[] pos = map.get(exit);
            res += shortestPath(matrix, pos[0], pos[1], dp);
        }
        System.out.println(res);
    }

    private static int shortestPath(boolean[][] matrix, int r, int c, Integer[][] dp) {
        final int n = matrix.length;
        final PriorityQueue<int[]> deque = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final boolean[][] visited = new boolean[n][n];
        deque.offer(new int[] { r, c, 0 });
        matrix[r][c] = false;
        while (!deque.isEmpty()) {
            final int[] curr = deque.remove();
            if (dp[curr[0]][curr[1]] != null) {
                return dp[curr[0]][curr[1]];
            }
            if (curr[0] == 0 || curr[0] == n - 1 || curr[1] == 0 || curr[1] == n - 1) {
                dp[r][c] = curr[2];
                return curr[2];
            }
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            for (int[] dir : DIRS) {
                final int nx = dir[0] + curr[0];
                final int ny = dir[1] + curr[1];
                deque.offer(new int[] { nx, ny, curr[2] + (matrix[nx][ny] ? 1 : 0) });
            }
        }
        return -1;
    }
}
