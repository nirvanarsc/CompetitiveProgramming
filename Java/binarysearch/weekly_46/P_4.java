package binarysearch.weekly_46;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_4 {

    public int solve(int[][] board) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final List<int[]> list = new ArrayList<>();
        final int n = board.length;
        final int m = board[0].length;
        if (n < m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pq.offer(new int[] { board[i][j], i, j });
                    if (pq.size() > 2) {
                        pq.remove();
                    }
                }
                while (!pq.isEmpty()) {
                    list.add(pq.remove());
                }
            }
        } else {
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    pq.offer(new int[] { board[i][j], i, j });
                    if (pq.size() > 2) {
                        pq.remove();
                    }
                }
                while (!pq.isEmpty()) {
                    list.add(pq.remove());
                }
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                final int[] l = list.get(i);
                final int[] r = list.get(j);
                if (l[1] != r[1] && l[2] != r[2]) {
                    res = Math.max(res, l[0] + r[0]);
                }
            }
        }
        return res;
    }
}
