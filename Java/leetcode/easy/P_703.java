package leetcode.easy;

import java.util.PriorityQueue;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_703 {

    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;
            for (int num : nums) {
                pqAdd(num);
            }
        }

        public int add(int val) {
            pqAdd(val);
            return pq.element();
        }

        private void pqAdd(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.remove();
            }
        }
    }
}
