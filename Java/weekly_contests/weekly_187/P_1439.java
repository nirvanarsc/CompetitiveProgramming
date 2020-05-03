package weekly_contests.weekly_187;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P_1439 {

    static class Item {
        int[] cols;
        int sum;

        Item(int[] cols, int sum) {
            this.cols = cols;
            this.sum = sum;
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        final int n = mat.length;
        final int m = mat[0].length;
        final PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        int sum = 0;
        for (int[] ints : mat) {
            sum += ints[0];
        }
        final Set<Integer> hash = new HashSet<>();
        pq.add(new Item(new int[n], sum));
        for (int i = 0; i < k - 1; i++) {
            final Item curr = pq.remove();
            for (int j = 0; j < n; j++) {
                final int[] next = curr.cols.clone();
                next[j]++;
                if (next[j] < m && hash.add(Arrays.hashCode(next))) {
                    pq.add(new Item(next, curr.sum - mat[j][next[j] - 1] + mat[j][next[j]]));
                }
            }
        }
        return pq.remove().sum;
    }
}
