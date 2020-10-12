package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return Collections.emptyList();
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            res.add(Arrays.asList(nums1[x], nums2[y]));
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
}
