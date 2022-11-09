package leetcode.weekly_contests.weekly_100_199.weekly_101;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_901 {

    class StockSpanner {
        Deque<int[]> dq;

        public StockSpanner() {
            dq = new ArrayDeque<>();
        }

        public int next(int price) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= price) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { price, curr });
            return curr;
        }
    }
}


