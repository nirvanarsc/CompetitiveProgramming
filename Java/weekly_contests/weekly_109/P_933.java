package weekly_contests.weekly_109;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_933 {

    static class RecentCounter {
        Deque<Integer> pq;

        RecentCounter() {
            pq = new ArrayDeque<>();
        }

        public int ping(int t) {
            pq.offerLast(t);
            while (pq.element() > t - 3000) {
                pq.removeFirst();
            }
            return pq.size();
        }
    }
}
