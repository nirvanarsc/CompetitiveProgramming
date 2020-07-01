package easy;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class P_703 {

    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;
            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.remove();
            }
            return pq.element();
        }
    }
}
