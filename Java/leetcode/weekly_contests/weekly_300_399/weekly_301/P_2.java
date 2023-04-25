package leetcode.weekly_contests.weekly_300_399.weekly_301;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class SmallestInfiniteSet {

        TreeSet<Integer> ts1 = new TreeSet<>();
        Set<Integer> ts2 = new HashSet<>();

        public SmallestInfiniteSet() {
            for (int i = 1; i <= 1000; i++) {
                ts1.add(i);
            }
        }

        public int popSmallest() {
            //noinspection ConstantConditions
            final int u = ts1.pollFirst();
            ts2.add(u);
            return u;
        }

        public void addBack(int num) {
            if (ts2.remove(num)) {
                ts1.add(num);
            }
        }
    }
}
