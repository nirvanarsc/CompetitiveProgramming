package leetcode.biweekly_contests.biweekly_51;

import java.util.TreeSet;

@SuppressWarnings({ "unused", "ConstantConditions", "InnerClassMayBeStatic" })
public class P_1845 {

    class SeatManager {
        TreeSet<Integer> ts = new TreeSet<>();

        SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                ts.add(i);
            }
        }

        public int reserve() {
            return ts.pollFirst();
        }

        public void unreserve(int seatNumber) {
            ts.add(seatNumber);
        }
    }
}
