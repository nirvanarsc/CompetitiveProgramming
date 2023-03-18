package leetcode.biweekly_contests.biweekly_0_99.biweekly_52;

import java.util.PriorityQueue;

public class P_1860 {

    public int[] memLeak(int memory1, int memory2) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0]
                                                                      ? Integer.compare(a[1], b[1])
                                                                      : Integer.compare(b[0], a[0]));
        pq.add(new int[] { memory1, 0 });
        pq.add(new int[] { memory2, 1 });
        int i = 1;
        while (pq.element()[0] >= i) {
            final int[] mem = pq.remove();
            pq.offer(new int[] { mem[0] - i++, mem[1] });
        }
        final int[] res = new int[2];
        final int[] pq1 = pq.remove();
        final int[] pq2 = pq.remove();
        res[pq1[1]] = pq1[0];
        res[pq2[1]] = pq2[0];
        return new int[] { i, res[0], res[1] };
    }
}
