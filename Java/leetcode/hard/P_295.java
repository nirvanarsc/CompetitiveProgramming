package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_295 {

    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        boolean odd;

        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            odd ^= true;
            max.add(num);
            min.add(max.remove());
            if (min.size() > max.size()) {
                max.add(min.remove());
            }
        }

        public double findMedian() {
            if (odd) {
                return max.element();
            } else {
                return 0.5 * (min.element() + max.element());
            }
        }
    }
}
