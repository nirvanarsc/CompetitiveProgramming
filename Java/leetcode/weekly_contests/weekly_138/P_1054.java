package leetcode.weekly_contests.weekly_138;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : barcodes) {
            freq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[] { e.getKey(), e.getValue() });
        }
        int idx = 0;
        while (pq.size() >= 2) {
            final int[] top1 = pq.remove();
            final int[] top2 = pq.remove();
            barcodes[idx++] = top1[0];
            barcodes[idx++] = top2[0];
            top1[1]--;
            top2[1]--;
            if (top1[1] > 0) {
                pq.offer(top1);
            }
            if (top2[1] > 0) {
                pq.offer(top2);
            }
        }
        if (!pq.isEmpty()) {
            barcodes[idx] = pq.remove()[0];
        }
        return barcodes;
    }
}
