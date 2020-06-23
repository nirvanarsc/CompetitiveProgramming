package medium;

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
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            res.add(Arrays.asList(nums1[x], nums2[y]));
            if (y + 1 < nums2.length) {
                pq.offer(new int[] { nums1[x] + nums2[y + 1], x, y + 1 });
            }
        }
        return res;
    }
}
