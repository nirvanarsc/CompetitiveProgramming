package leetcode.biweekly_contests.biweekly_0_99.biweekly_18;

import java.util.PriorityQueue;

public class P_1329 {

    public int[][] diagonalSort(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        for (int c = m - 1; c >= 0; c--) {
            final PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0, j = c; i < n && j < m; i++, j++) {
                pq.offer(mat[i][j]);
            }
            for (int i = 0, j = c; i < n && j < m; i++, j++) {
                mat[i][j] = pq.remove();
            }
        }
        for (int r = 1; r < n; r++) {
            final PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = r, j = 0; i < n && j < m; i++, j++) {
                pq.offer(mat[i][j]);
            }
            for (int i = r, j = 0; i < n && j < m; i++, j++) {
                mat[i][j] = pq.remove();
            }
        }
        return mat;
    }
}
