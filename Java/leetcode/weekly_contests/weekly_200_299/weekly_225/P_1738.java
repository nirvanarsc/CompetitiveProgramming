package leetcode.weekly_contests.weekly_200_299.weekly_225;

import java.util.PriorityQueue;

public class P_1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] pre = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < m; j++) {
                row ^= matrix[i][j];
                pre[i + 1][j] = pre[i][j] ^ row;
                pq.add(pre[i + 1][j]);
                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }
        return pq.element();
    }
}
