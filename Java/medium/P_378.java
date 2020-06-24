package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_378 {

    static class Tuple {
        int x, y, val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int count = getLessThan(matrix, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int getLessThan(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix[0].length - 1;
        for (int[] ints : matrix) {
            while (j >= 0 && ints[j] > mid) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }

    public int kthSmallestPQ(int[][] matrix, int k) {
        final PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int j = 0; j < matrix.length; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            final Tuple t = pq.remove();
            if (t.x < matrix.length - 1) {
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
        }
        return pq.remove().val;
    }

    public int kthSmallestPQ2(int[][] matrix, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(ints[j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.remove();
    }

    public static int kthSmallestPairs(int[][] matrix, int k) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { matrix[0][0], 0, 0 });
        for (int i = 0; i < k - 1 && !pq.isEmpty(); i++) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            add(matrix, x, y + 1, pq);
            if (y == 0) {
                add(matrix, x + 1, 0, pq);
            }
        }
        return pq.remove()[0];
    }

    private static void add(int[][] matrix, int i, int j, PriorityQueue<int[]> pq) {
        if (i < matrix.length && j < matrix[0].length) {
            pq.offer(new int[] { matrix[i][j], i, j });
        }
    }
}
