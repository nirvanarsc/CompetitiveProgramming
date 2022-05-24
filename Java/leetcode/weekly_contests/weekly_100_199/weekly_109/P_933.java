package leetcode.weekly_contests.weekly_100_199.weekly_109;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_933 {

    class RecentCounter {
        Deque<Integer> deque;

        RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!deque.isEmpty() && deque.getLast() < t - 3000) {
                deque.removeLast();
            }
            deque.addFirst(t);
            return deque.size();
        }
    }
}
