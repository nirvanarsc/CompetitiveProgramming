package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class P_346 {

    class MovingAverage {
        Deque<Integer> deque;
        int size;
        double sum;

        MovingAverage(int size) {
            deque = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (deque.size() == size) {
                sum -= deque.removeLast();
            }
            deque.addFirst(val);
            sum += val;
            return sum / deque.size();
        }
    }
}
