package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_295 {

    public static class MedianFinder {

        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        public MedianFinder() {
            max = new PriorityQueue<>(Comparator.reverseOrder());
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.add(num);
            max.add(min.remove());
            if (max.size() > min.size()) {
                min.add(max.remove());
            }
        }

        public double findMedian() {
            if (min.size() != max.size()) {
                return min.element();
            } else {
                return 0.5 * (min.element() + max.element());
            }
        }
    }
}
