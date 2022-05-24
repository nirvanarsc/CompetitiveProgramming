package leetcode.weekly_contests.weekly_100_199.weekly_187;

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

    public int kthSmallestPQ(int[][] mat, int k) {
        return solve(0, mat.length - 1, mat, k)[k - 1];
    }

    private int[] solve(int i, int j, int[][] mat, int k) {
        if (i == j) {
            return mat[i];
        }
        final int mid = i + j >>> 1;
        final int[] l1 = solve(i, mid, mat, k);
        final int[] l2 = solve(mid + 1, j, mat, k);
        return kSmallestPairs(l1, l2, k);
    }

    public int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        final int[] res = new int[Math.min(k, nums1.length * nums2.length)];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            res[i] = nums1[x] + nums2[y];
            add(nums1, nums2, x, y + 1, pq);
            if (y == 0) {
                add(nums1, nums2, x + 1, 0, pq);
            }
        }
        return res;
    }

    private static void add(int[] nums1, int[] nums2, int i, int j, PriorityQueue<int[]> pq) {
        if (i < nums1.length && j < nums2.length) {
            pq.offer(new int[] { nums1[i] + nums2[j], i, j });
        }
    }

    public int kthSmallestBS(int[][] mat, int k) {
        final int n = mat.length;
        int lo = n, hi = n * 5000;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int count = countLess(mat, mid, 0, 0, k);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int countLess(int[][] mat, int targetSum, int r, int sum, int k) {
        if (sum > targetSum) { return 0; }
        if (r == mat.length) { return 1; }
        int res = 0;
        for (int c = 0; c < mat[0].length && res < k; c++) {
            final int count = countLess(mat, targetSum, r + 1, sum + mat[r][c], k);
            if (count == 0) {
                break;
            }
            res += count;
        }
        return res;
    }
}
