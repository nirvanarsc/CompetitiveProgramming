package binarysearch.weekly_28;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    private static final class MedianFinder {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        private MedianFinder() {
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

        public int findMedian() {
            if (min.size() != max.size()) {
                return min.element();
            } else {
                return (min.element() + max.element()) >>> 1;
            }
        }
    }

    public int solve(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            final MedianFinder mf = new MedianFinder();
            for (int j = i; j < nums.length; j++) {
                mf.addNum(nums[j]);
                if ((j - i) % 2 == 0) {
                    res += mf.findMedian();
                }
            }
        }
        return res;
    }
}
