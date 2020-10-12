package atcoder.beginner_176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class D {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private static final int[][] PAID = {
            { -2, -2 }, { -2, -1 }, { -2, 0 }, { -2, 1 }, { -2, 2 }, { -1, -2 },
            { -1, -1 }, { -1, 1 }, { -1, 2 }, { 0, -2 }, { 0, 2 }, { 1, -2 }, { 1, -1 },
            { 1, 1 }, { 1, 2 }, { 2, -2 }, { 2, -1 }, { 2, 0 }, { 2, 1 }, { 2, 2 }
    };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line1 = in.nextLine().split(" ");
        final int n = Integer.parseInt(line1[0]);
        final int m = Integer.parseInt(line1[1]);
        final String[] line2 = in.nextLine().split(" ");
        final int sx = Integer.parseInt(line2[0]) - 1;
        final int sy = Integer.parseInt(line2[1]) - 1;
        final String[] line3 = in.nextLine().split(" ");
        final int dx = Integer.parseInt(line3[0]) - 1;
        final int dy = Integer.parseInt(line3[1]) - 1;
        final char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.nextLine().toCharArray();
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final boolean[][] visited = new boolean[n][m];
        pq.offer(new int[] { sx, sy, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int x = curr[0];
            final int y = curr[1];
            if (x == dx && y == dy) {
                System.out.println(curr[2]);
                return;
            }
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] != '#') {
                    pq.offer(new int[] { nx, ny, curr[2] });
                }
            }
            for (int[] dir : PAID) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] != '#') {
                    pq.offer(new int[] { nx, ny, curr[2] + 1 });
                }
            }
        }
        System.out.println(-1);
    }
}
