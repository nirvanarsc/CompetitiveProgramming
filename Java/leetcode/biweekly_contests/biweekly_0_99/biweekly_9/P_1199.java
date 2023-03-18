package leetcode.biweekly_contests.biweekly_0_99.biweekly_9;

import java.util.PriorityQueue;

public class P_1199 {

    // https://en.wikipedia.org/wiki/Huffman_coding
    public int minBuildTime(int[] blocks, int split) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int b : blocks) {
            pq.add(b);
        }
        while (pq.size() > 1) {
            pq.remove();
            pq.add(pq.remove() + split);
        }
        return pq.remove();
    }
}
