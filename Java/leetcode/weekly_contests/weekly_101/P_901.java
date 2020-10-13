package leetcode.weekly_contests.weekly_101;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_901 {

    class StockSpanner {
        Deque<int[]> stack;

        StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int curr = 1;
            while (!stack.isEmpty() && stack.peekFirst()[0] <= price) {
                curr += stack.removeFirst()[1];
            }
            stack.addFirst(new int[] { price, curr });
            return curr;
        }
    }
}


